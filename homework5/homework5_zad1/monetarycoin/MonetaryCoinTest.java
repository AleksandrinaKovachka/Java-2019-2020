package monetarycoin;

public class MonetaryCoinTest
{
    public static void main(String[] args)
    {
        int sum = 0;
        MonetaryCoin coin1 = new MonetaryCoin(Face.HEAD, 20);
        System.out.println("Coin1: " + coin1.toString());
        coin1.flip();
        System.out.println("Coin1: " + coin1.toString());

        MonetaryCoin coin2 = new MonetaryCoin(Face.TAIL, 100);
        System.out.println("Coin2: " + coin2.toString());
        coin2.flip();
        System.out.println("Coin2: " + coin2.toString());

        MonetaryCoin coin3 = new MonetaryCoin(Face.HEAD, 15); //check value and turn to 1
        System.out.println("Coin3: " + coin3.toString());
        coin3.flip();
        System.out.println("Coin3: " + coin3.toString());

        sum = coin1.getValue() + coin2.getValue() + coin3.getValue();
        System.out.println("Sum of value: " + sum);
    }
}
