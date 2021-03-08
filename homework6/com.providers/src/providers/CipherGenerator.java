package providers;

import services.Cipherable;

public class CipherGenerator
{
    public static Result countDistinct(Cipherable cipher, int seed)
    {
        char[] charArray = cipher.getSecretChars(seed);
        char current;
        boolean haveElement = false;
        int data = 0;
        for(int i = 0; i < charArray.length - 1; ++i)
        {
            haveElement = false;
            current = charArray[i];
            for(int j = i + 1; j < charArray.length; ++j)
            {
                if(current == charArray[j])
                {
                    haveElement = true;
                    break;
                }
            }

            for(int k = i - 1; k >= 0; --k)
            {
                if(current == charArray[k])
                {
                    haveElement = true;
                    break;
                }
            }

            if(!haveElement)
            {
                ++data;
            }
        }

        return new Result(charArray, data);
    }
}
