package com;

public class Stock
{
    private String symbol; // the symbol of this stock
    private String name; // the name of this stock
    private double previousClosingPrice; // the previous closing price of this stock
    private double currentPrice; // the current price of this stock

   // construct a stock with a specified symbol and a name
    public Stock(String symbol, String name)
    {
        this.symbol = symbol;
        this.name = name;
    }

    // return the symbol of this stock
    public String getSymbol()
    {
        return symbol;
    }

    //return the name of this stock
    public String getName()
    {
        return name;
    }

    // return the previous closing price of this stock
    public double getPreviousClosingPrice()
    {
        return previousClosingPrice;
    }

    // return the current price of this stock
    public double getCurrentPrice()
    {
        return currentPrice;
    }

    // sets the previous closing price of this stock
    public void setPreviousClosingPrice(double previousClosingPrice)
    {
        if(previousClosingPrice <= 0)
        {
            this.previousClosingPrice = 1;
        }
        else
        {
            this.previousClosingPrice = previousClosingPrice;
        }
    }

    // sets the current price of this stock
    public void setCurrentPrice(double currentPrice)
    {
        if(currentPrice <= 0)
        {
            this.currentPrice = 1;
        }
        else
        {
            this.currentPrice = currentPrice;
        }
    }

    // return the percentage of change of this stock
    public double changePercent()
    {
        double percent; // the percentage of change of this stock

        //percent = Math.abs(currentPrice - previousClosingPrice);
        //percent /= previousClosingPrice * 100;

        percent = Math.abs(currentPrice - previousClosingPrice) / Math.min(currentPrice, previousClosingPrice);
        percent *= 100;
        return percent;
    }
}
