import com.Stock;

public class StockTest
{
    public static void main(String[] args)
    {
        Stock stock1 = new Stock("$#", "Apple");

        System.out.println(stock1.getName());

        stock1.setPreviousClosingPrice(1.230);
        stock1.setCurrentPrice(1.430);

        System.out.println(stock1.getPreviousClosingPrice());
        System.out.println(stock1.getCurrentPrice());

        double percent = stock1.changePercent();
        System.out.printf("The percent: %.2f%c", percent, '%');
    }
}
