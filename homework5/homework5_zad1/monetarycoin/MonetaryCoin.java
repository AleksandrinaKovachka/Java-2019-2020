package monetarycoin;

public class MonetaryCoin extends Coin //class MonetaryCoin extends class Coin
{
    private int value;

    public MonetaryCoin(Face face, int value)
    {
        super(face); //Invoke the superclass constructor
        setValue(value);
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100 || value == 200)
        {
            this.value = value;
        }
        else
        {
            this.value = 1;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s, Value: %d", super.toString(), value);
    }
}
