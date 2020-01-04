public class Lab3
{
    public static void testLightCandles1()
    {
        Robot.load("candles1.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles2()
    {
        Robot.load("candles2.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void lightCandles()
    {
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
        IfCandleSmall();
    }

    public static void IfCandleSmall()
    //precondition: Robot is standing before a Candle one square tall
    //postcondition: Robot has lit the Small Candle and is ready to test the next Candle
    {
        if(IsCandleSmall())
        {
            Robot.move();
            Robot.makeDark();
            Robot.move();
            Lab2.turnRight();
            Robot.move();
            Robot.turnLeft();
        }
        else
        {
            Robot.turnLeft();
            Robot.move();
            Lab2.turnRight();
            IfCandleBig();
        }
    }

    public static void IfCandleBig()
    //precondition: Robot is standing before a Candle two squares tall
    //postcondition: Robot has lit the Big Candle and is ready to test the next Candle
    {
        if(IsCandleBig())
        {
            Robot.move();
            Robot.makeDark();
            Robot.move();
            Lab2.turnRight();
            Robot.move();
            Robot.move();
            Robot.turnLeft();
        }
    }
    
    public static boolean IsCandleBig()
    //precondition: Robot is facing a candle that potentially is two squares tall
    //postcondition: Robot is facing a candle with knowledge it is two squares tall
    {
        if(Robot.frontIsClear())
        {
            return true;   
        }
        else
            return false;
    }
    
    public static boolean IsCandleSmall()
    //precondition: Robot is facing a candle that potentially is only one square tall
    //postcondition: Robot is facing a candle with knowledge it is only one square tall
    {
        Robot.turnLeft();
        Robot.move();
        Lab2.turnRight();
        if(Robot.frontIsClear())
        {
            return true;   
        }
        else
            return false;
    }

    //Run this method to test completeRoom on map room1.txt
    public static void testCompleteRoom1()
    {
        Robot.load("room1.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    //Run this method to test completeRoom on map room2.txt
    public static void testCompleteRoom2()
    {
        Robot.load("room2.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    //Complete this method.  You will need to write additional helper methods.
    public static void completeRoom()
    {
        CompleteSide();
        CompleteSide();
        CompleteSide();
        CompleteSide();
    }

    public static void CompleteSide()
    //precondition: Robot is at the beginning of one side of the Room
    //postcondition: Robot is at the end of the side of the Room, having darkened all possible squares in the wall
    {
        IfNextToLightSpace();
        IfNextToLightSpace();
        IfNextToLightSpace();
        IfNextToLightSpace();
        EndofLine();
    }
    
    public static void EndofLine()
    //precondition: Robot is in a corner of the Room
    //postcondition: Robot has made the square to its left dark or is ready to test the next side of the Room
    {
        if(IsNextToLightSpace())
        {
        Robot.makeDark();
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        }
        else
        {
            if(!Robot.onDark())
            {
        Lab2.turnRight();
        Lab2.turnRight();
        }
        if(Robot.onDark())
        {
            Robot.turnLeft();
            Robot.turnLeft();
            Robot.move();
        }
    }
    }
    
    public static void IfNextToLightSpace()
    //precondition: Robot has a square on the left that may be a light space
    //postcondition: Robot has either darkened the space or left the square and moved to the next square
    {
        if(IsNextToLightSpace())
        {
        Robot.makeDark();
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        Robot.turnLeft();
        Robot.move();
        }
        else
        {
            if(!Robot.onDark())
            {
        Lab2.turnRight();
        Robot.move();
        }
        else
        {
            Robot.turnLeft();
            Robot.turnLeft();
            Robot.move();
            Robot.turnLeft();
            Robot.move();
        }
    }
    }
    
    public static boolean IsNextToLightSpace()
    //precondition: Robot has a square to the left that could be a light space
    //postcondition: Robot has verified square to the left is a light space
    {
        Robot.turnLeft();
        if(Robot.frontIsClear())
           
        {
          Robot.move();
            if(!Robot.onDark())
            {
            return true;
            }
            else
            {
                return false;
            }  
            }
            else
            {
                return false;
            }
    }

//Run this method to test swapAll on map swap1.txt
    public static void testSwapAll1()
    {
        Robot.load("swap1.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Run this method to test swapAll on map swap2.txt
    public static void testSwapAll2()
    {
        Robot.load("swap2.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Complete this method.  You will need to write additional helper methods.
    public static void swapAll()
    {
        switchRow();
        switchRow();
        switchRow();
        switchRow();
        switchRow();
        switchRow();
        switchRow();
        switchRow();
        switchRow();
        LeftDark();
    }
    
    public static void switchRow()
    //precondition: Robot is ready to switch the two colors to its sides
    //postcondition: Robot has switched or left the colors unchanged, and moved to the next row
    {
        LeftDark();
        Robot.move();
    }
    
    public static void LeftDark()
    //precondition: the Robot is ready to switch the two colors to its sides
    //postcondition: the Robot has either switched the two colors or kept them the same
    {
        if (leftDark())
        {
            moveOpposite();
            if (rightDark())
            {
                Robot.turnLeft();
                Robot.turnLeft();
                Robot.move();
                Lab2.turnRight();
            }
            else
            {
                Robot.makeDark();
                moveOpposite();
                Robot.makeLight();
                Robot.turnLeft();
                Robot.turnLeft();
                Robot.move();
                Robot.turnLeft();
            }
        }
        else
        {
            LeftLight();
        }
    }
    
    public static void LeftLight()
    //precondition: the square to Robot's left is light
    //postcondition: the square to Robot's right is now unchanged or light
    {
        moveOpposite();
            if(!rightDark())
            {
                Robot.turnLeft();
                Robot.turnLeft();
                Robot.move();
                Lab2.turnRight();
            }
            else
            {
                Robot.makeLight();
                moveOpposite();
                Robot.makeDark();
                Robot.turnLeft();
                Robot.turnLeft();
                Robot.move();
                Robot.turnLeft();
            }
    }
    
    public static void moveOpposite()
    //precondition: Robot is on the left/right side of the path
    //postcondition: Robot has moved to the right/left side of the path
    {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        }
    
    public static boolean rightDark()
    //precondition: the square, on the right side, that Robot is on may be Dark
    //postcondition: Robot knows whether or not the square it is on is Dark
    {
        if(Robot.onDark())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean leftDark()
    //precondition: the square to Robot's left may or may not be Dark
    //postcondition: Robot knows whether or not the square to its left is Dark
    {
        Robot.turnLeft();
        Robot.move();
        if(Robot.onDark())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Don't run these. I will!
    public static void testLightCandles3()
    {
        Robot.load("candles3.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles4()
    {
        Robot.load("candles4.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testCompleteRoom3()
    {
        Robot.load("room3.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testCompleteRoom4()
    {
        Robot.load("room4.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testSwapAll3()
    {
        Robot.load("swap3.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Run this method to test swapAll on map swap2.txt
    public static void testSwapAll4()
    {
        Robot.load("swap4.txt");
        Robot.setDelay(0.05);
        swapAll();
    }
}
