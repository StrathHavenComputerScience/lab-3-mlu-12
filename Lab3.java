
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
    {
        IfNextToLightSpace();
        IfNextToLightSpace();
        IfNextToLightSpace();
        IfNextToLightSpace();
        EndofLine();
    }
    
    public static void EndofLine()
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
        //insert instructions below

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
