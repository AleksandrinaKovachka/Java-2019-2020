package providers;

import java.util.Arrays;

public class Result
{
    private char[] chars;
    private int data;

    public Result(char[] chars, int data)
    {
        setChars(chars);
        setData(data);
    }

    public char[] getChars()
    {
        char[] returnArray = new char[chars.length];
        for(int i = 0; i < chars.length; ++i)
        {
            returnArray[i] = chars[i];
        }

        return returnArray;
    }

    public void setChars(char[] chars)
    {
        if(chars.length > 0)
        {
            this.chars = new char[chars.length];
            for(int i = 0; i < chars.length; ++i)
            {
                this.chars[i] = chars[i];
            }
        }
        else
        {
            this.chars = new char[0];
        }
    }

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data > 0 ? data : 1;
    }

    @Override
    public String toString()
    {
        return String.format("Chars: %s\nResult: %d", Arrays.toString(chars), data);
    }
}
