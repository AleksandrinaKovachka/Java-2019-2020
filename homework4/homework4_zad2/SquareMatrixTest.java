package squarematrix;

import java.util.Arrays;
import java.util.Random;

public class SquareMatrixTest
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int rowAndCow = random.nextInt(11) + 2;

        int[][] matrix = new int[rowAndCow][rowAndCow];
        for(int i = 0; i < rowAndCow; ++i)
        {
            for(int j = 0; j < rowAndCow; ++j)
            {
                matrix[i][j] = random.nextInt(9);
            }
        }

        SquareMatrix s = new SquareMatrix(matrix);
        String result = s.toString();
        System.out.println(result);
        s.printAll();
    }
}
