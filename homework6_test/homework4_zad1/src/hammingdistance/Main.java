package hammingdistance;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static int hammingDistance(byte first, byte second)
    {
        int resultInOR = first ^ second;
        int distance = 0;

        while(resultInOR > 0)
        {
            distance += resultInOR & 1; //bitwise AND
            resultInOR >>= 1; //right shift
        }

        return distance;
    }

    public static void printInBinary(byte number)
    {

        int mask = 1 << 8;
        for(int i = 0; i < 8; ++i)
        {
            System.out.print((number & mask) == 0 ? '0' : '1');
            number <<= 1;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        byte firstNumber;
        byte secondNumber;

        System.out.print("Input first number: ");
        firstNumber = input.nextByte();

        System.out.print("Input second number: ");
        secondNumber = input.nextByte();

        int hammingDistance = hammingDistance(firstNumber, secondNumber);

        System.out.print("First byte number in binary: ");
        printInBinary(firstNumber);
        System.out.print("Second byte number in binary: ");
        printInBinary(secondNumber);
        System.out.println("Hamming distance is: " + hammingDistance);
    }
}
