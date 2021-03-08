//program to generate random number from within [1;3] and display the probabilities as percentages
package zad3;

import java.text.NumberFormat;
import java.util.Random;

public class Zad3
{
    //static method to generate random number
    public static int drawRandomNumber()
    {
        Random rand = new Random();
        int number;
        number =rand.nextInt(100);
        if(number <= 20)
        {
            return 1;
        }
        else if(number <= 30)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }


    public static void main(String[] args)
    {
        //test with 10_000 times
        int randomNumber;
        int countFor1 = 0;
        int countFor2 = 0;
        int countFor3 = 0;

        for(int i = 0; i < 10_000; ++i)
        {
            randomNumber = drawRandomNumber();
            switch (randomNumber)
            {
                case 1: ++countFor1; break;
                case 2: ++countFor2; break;
                case 3: ++countFor3; break;
            }
        }

        NumberFormat percentage = NumberFormat.getPercentInstance();
        System.out.println("The percentage of 1 in 10 000: " + percentage.format(countFor1/(double)10_000));
        System.out.println("The percentage of 2 in 10 000: " + percentage.format(countFor2/(double)10_000));
        System.out.println("The percentage of 3 in 10 000: " + percentage.format(countFor3/(double)10_000));

        //test with 60_000 timeя
        countFor1 = 0;
        countFor2 = 0;
        countFor3 = 0;

        for(int i = 0; i < 60_000; ++i)
        {
            randomNumber = drawRandomNumber();
            switch (randomNumber)
            {
                case 1: ++countFor1; break;
                case 2: ++countFor2; break;
                case 3: ++countFor3; break;
            }
        }

        NumberFormat percentage2 = NumberFormat.getPercentInstance();
        System.out.println("The percentage of 1 in 60 000: " + percentage2.format(countFor1/(double)60_000));
        System.out.println("The percentage of 2 in 60 000: " + percentage2.format(countFor2/(double)60_000));
        System.out.println("The percentage of 3 in 60 000: " + percentage2.format(countFor3/(double)60_000));
    }
}
