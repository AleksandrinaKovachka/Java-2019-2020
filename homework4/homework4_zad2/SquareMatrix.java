package squarematrix;

import java.util.Arrays;

public class SquareMatrix
{
    int[][] dataArray;

    public SquareMatrix(int[][] dataArray)
    {
        this.dataArray = dataArray;
    }

    public SquareMatrix()
    {
        setDataArray(null);
    }

    public SquareMatrix(SquareMatrix s)
    {
        this(s.getDataArray());
    }

    public int[][] getDataArray()
    {
        int[][] returnArray = new int[dataArray.length][dataArray[0].length];

        for(int i = 0; i < dataArray.length; ++i)
        {
            for(int j = 0; j < dataArray[i].length; ++j)
            {
                returnArray[i][j] = dataArray[i][j];
            }
        }

        return returnArray;
    }

    public void setDataArray(int[][] dataArray)
    {
        if(dataArray != null)
        {
            this.dataArray = new int[dataArray.length][dataArray[0].length];
            for(int i = 0; i < dataArray.length; ++i)
            {
                for(int j = 0; j < dataArray[i].length; ++j)
                {
                    this.dataArray[i][j] = dataArray[i][j];
                }
            }
        }
        else
        {
            this.dataArray = new int[1][1];
            dataArray[0][0] = 0;
        }
    }

    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; i < dataArray.length; ++i)
        {
            for(int j = 0; j < dataArray[i].length; ++j)
            {
                result += String.format("dataArray[%d][%d]: %d ", i, j, dataArray[i][j]);
            }
            result += "\n";
        }

        return result;
    }

    public int findMaxSum()
    {
        int[] getArray = checkMatrix();
        return getArray[0];
    }

    public void printAll()
    {
        int[] getArray = checkMatrix();
        System.out.printf("Maximum sum: %d\n", getArray[0]);
        int pos = 1;
        while(getArray[pos] != -1) //докато до стигне края на добавените ред и колона
        {
            System.out.printf("Submatrices with Maximum sum: \n[%d, %d]\n", getArray[pos++], getArray[pos++]);
        }
    }

    private int[] checkMatrix()
    {
        int size = dataArray.length * dataArray[0].length;
        int[] arr = new int[size]; //На първа позиция в масива съхранявам най-голямата сума от подматрица, следващите елементи са ред и колона на подматриците с най-голямата сума
        for(int i = 0; i < size; ++i) //генерирам целия масив с -1 защото няма как ред и колона да имат номер -1
        {
            arr[i] = -1;
        }
        int sum;
        int pos = 1;

        for(int i = 0; i < dataArray.length - 1; ++i)
        {
            for(int j = 0; j < dataArray[i].length - 1; ++j)
            {
                sum = dataArray[i][j] + dataArray[i + 1][j] + dataArray[i][j + 1] + dataArray[i + 1][j + 1];
                if(arr[0] < sum)
                {
                    arr[0] = sum;
                    pos = 1; //нулирам всички до сега добавени редове, тъй като те вече не са най-големите
                    arr[pos++] = i;
                    arr[pos++] = j;
                }
                else if(arr[0] == sum)
                {
                    arr[pos++] = i;
                    arr[pos++] = j;
                }
            }

        }

        return arr;
    }
}
