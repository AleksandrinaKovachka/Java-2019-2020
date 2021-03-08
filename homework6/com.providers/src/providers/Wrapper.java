package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper
{
    private int size; //size of char array

    public Wrapper(int size)
    {
        setSize(size);
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size > 0 ? size : 1;
    }

    public Cipherable makeFixedSelector()
    {
        return new FixedRandom();
    }

    public Cipherable makeFixedRandom()
    {
        return new FixedSelection();
    }

    private class FixedRandom implements Cipherable
    {
        @Override
        public char[] getSecretChars(int seed)
        {
            char[] charArray = new char[size];
            Random rand = new Random(seed);

            for(int i = 0; i < size; ++i)
            {
                charArray[i] = (char) (rand.nextInt(26) + 'A');
            }

            return charArray;
        }
    }

    private class FixedSelection implements Cipherable
    {
        @Override
        public char[] getSecretChars(int seed)
        {
            char[] charArray = new char[size];
            char[] charSeed = new char[seed];
            Random rand = new Random();

            for(int i = 0; i < seed; ++i)
            {
                charSeed[i] = (char) (rand.nextInt(26) + 'A');
            }

            int index = 0;
            for(int i = 0; i < size; ++i)
            {
                index = rand.nextInt(seed);
                charArray[i] = charSeed[index];
            }

            return charArray;
        }
    }
}
