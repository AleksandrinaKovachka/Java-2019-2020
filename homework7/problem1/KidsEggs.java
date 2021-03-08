package problem1;

import java.util.ArrayList;
import java.util.Random;

public class KidsEggs
{
    private static ArrayList<Integer> animalHero = new ArrayList<>();

    public static void generateAnimalHero()
    {
        for (int i = 0; i < 10; ++i)
        {
            animalHero.add(i, i + 1);
        }
    }

    public static int getEgg()
    {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    public static boolean findInList(int egg)
    {
        for(int i = 0; i < animalHero.size(); ++i)
        {
            if(animalHero.contains(egg))
            {
                if(animalHero.remove((Object) egg))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        double sum = 0;
        int countAnimalHero = 0;
        int countEggs = 0;
        generateAnimalHero();
        int egg;
        while(sum < 7 && animalHero.size() > 0)
        {
            egg = getEgg();
            if(findInList(egg))
            {
                ++countAnimalHero;
            }
            ++countEggs;
            sum += 0.5;
        }

        System.out.printf("You have %d different animal hero and average sum is: %f", countAnimalHero, sum/countEggs);

        animalHero.clear();
    }

}
