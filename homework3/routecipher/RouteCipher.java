package routecipher;

import java.util.Arrays;

public class RouteCipher
{
    private int key;

    public RouteCipher(int key)
    {
        setKey(key);
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        if(key != 0)
        {
            this.key = key;
        }
        else
        {
            this.key = 1;
        }
    }

    public String encrypt(String plainText)
    {
        char[] plainTextArray = plainText.toCharArray();
        plainTextArray = changeCharArray(plainTextArray);
        char[][] matrix = makeMatrix(plainTextArray);

        int pos = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int length = row * col;

        char[] cipherText = new char[length];

        if(key > 0) //започва запълване на новия масив от горен ляв ъгъл
        {
            int start = 0;
            int stop1 = row - 1;
            int stop2 = col - 1;
            int i = 0;
            int j = 0;

            while(pos < length)
            {

                for(i = start; i <= stop1; ++i) //запълва с колоната от горен ляв ъгъл до долен ляв ъгъл
                {
                    cipherText[pos++] = matrix[i][start];
                }

                if(pos >= length) //проверка дали не е запълнен масива
                {
                    break;
                }

                for(j = start + 1; j <= stop2; ++j) //запълва с реда от долен ляв ъгъл до долен десен ъгъл
                {
                    cipherText[pos++] = matrix[i - 1][j];
                }

                if(pos >= length)
                {
                    break;
                }

                for(i = stop1 - 1; i >= start; --i) //запълва с колоната от долен десен ъгъл до горен ляв
                {
                    cipherText[pos++] = matrix[i][j - 1];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = stop2 - 1; j >= start + 1; --j) //запълва с реда от горен десен ъгъл до горен ляв
                {
                    cipherText[pos++] = matrix[start][j];
                }
                ++start;
                --stop1;
                --stop2;
            }
        }
        else //започва запълването на новия масив от долен десен ъгъл
        {
            int start1 = row - 1;
            int start2 = col - 1;
            int stop = 0;
            int i = 0;
            int j = 0;

            while(pos < length)
            {

                for(i = start1; i >= stop; --i) //запълва с колоната от долен десен ъгъл до горен десен ъгъл
                {
                    cipherText[pos++] = matrix[i][start2];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = start2 - 1; j >= stop; --j)//запълва с реда от горен десен ъгъл до горен ляв
                {
                    cipherText[pos++] = matrix[stop][j];
                }

                if(pos >= length)
                {
                    break;
                }

                for(i = stop + 1; i <= start1; ++i) //запълва с колоната от горен ляв ъгъл до долен ляв
                {
                    cipherText[pos++] = matrix[i][stop];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = stop + 1; j <= start2 - 1; ++j) //запълва с реда от долен ляв ъгъл до долен десен
                {
                    cipherText[pos++] = matrix[start1][j];
                }
                --start1;
                --start2;
                ++stop;
            }
        }

        String text = new String(cipherText);
        return text;
    }

    public String decrypt(String cipherText)
    {
        char[] cipherTextArray = cipherText.toCharArray();
        int length = cipherTextArray.length;
        int col = Math.abs(key);
        int row = length / col;
        char[][] matrix = new char[row][col];
        int pos = 0;

        if(key > 0) //започва пълненето на новата матрица от горен ляв ъгъл
        {
            int start = 0;
            int stop1 = row - 1;
            int stop2 = col - 1;
            int i = 0;
            int j = 0;

            while(pos < length)
            {

                for(i = start; i <= stop1; ++i)
                {
                    matrix[i][start] = cipherTextArray[pos++];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = start + 1; j <= stop2; ++j)
                {
                   matrix[i - 1][j] = cipherTextArray[pos++];
                }

                if(pos >= length)
                {
                    break;
                }

                for(i = stop1 - 1; i >= start; --i)
                {
                   matrix[i][j - 1] = cipherTextArray[pos++];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = stop2 - 1; j >= start + 1; --j)
                {
                    matrix[start][j] = cipherTextArray[pos++];
                }
                ++start;
                --stop1;
                --stop2;
            }
        }
        else //започва пълненето на новата матрица от долен десен ъгъл
        {
            int start1 = row - 1;
            int start2 = col - 1;
            int stop = 0;
            int i = 0;
            int j = 0;

            while(pos < length)
            {
                for(i = start1; i >= stop; --i)
                {
                    matrix[i][start2] = cipherTextArray[pos++];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = start2 - 1; j >= stop; --j)
                {
                    matrix[stop][j] = cipherTextArray[pos++];
                }

                if(pos >= length)
                {
                    break;
                }

                for(i = stop + 1; i <= start1; ++i)
                {
                    matrix[i][stop] = cipherTextArray[pos++];
                }

                if(pos >= length)
                {
                    break;
                }

                for(j = stop + 1; j <= start2 - 1; ++j)
                {
                    matrix[start1][j] = cipherTextArray[pos++];
                }
                --start1;
                --start2;
                ++stop;
            }
        }

        char[] plainText = makeCharArray(matrix);
        String text = new String(plainText);
        return text;
    }

    private char[] changeCharArray(char[] charArray)
    {
        int length = charArray.length;
        for(int i = 0; i < length; ++i)
        {
            if(charArray[i] == ' ' || charArray[i] == ',')
            {
                for(int j = i; j < length - 1; ++j)
                {
                    charArray[j] = charArray[j + 1];
                }
                --length;
                --i;
            }
        }
        return Arrays.copyOfRange(charArray, 0, length);
    }

    private char[][] makeMatrix(char[] charArray)
    {
        int col = Math.abs(key);
        int lengthOfCharArray = charArray.length;
        int row = lengthOfCharArray / col;
        if(lengthOfCharArray % col != 0)
        {
            ++row;
        }
        char[][] matrix = new char[row][col];
        int position = 0;
        for(int i = 0; i < row; ++i)
        {
            for(int j = 0; j < col; ++j)
            {
                if(position == lengthOfCharArray)
                {
                    matrix[i][j] = 'X';
                    continue;
                }
                matrix[i][j] = charArray[position++];
            }
        }

        return matrix;
    }

    private char[] makeCharArray(char[][] matrix)
    {
        int cnt = 0;
        for(int i = matrix.length - 1, j = 1; j < matrix[0].length; ++j) //проверява на последния ред колко пъти се среща Х за да ги премахне от новия масив
        {
            if(matrix[i][j] == 'X')
            {
                ++cnt;
            }
        }
        if(cnt != 0) //ако има Х то винаги оставям по един Х в новия масив, защото не съм сигурна думата дали завършва с Х или е добавен от криптирането
        {
            --cnt;
        }
        int length = (matrix.length * matrix[0].length) - cnt;
        char[] newArray = new char[length];
        int pos = 0;

        for(int i = 0; i < matrix.length; ++i)
        {
            for(int j = 0; j < matrix[i].length; ++j)
            {
                if(pos >= length)
                {
                    break;
                }
                newArray[pos++] = matrix[i][j];
            }
        }

        return newArray;
    }

    @Override
    public String toString()
    {
        return String.format("The key is: %s", key);
    }
}
