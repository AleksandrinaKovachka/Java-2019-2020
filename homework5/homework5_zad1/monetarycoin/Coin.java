package monetarycoin;

import java.util.Random;

public class Coin
{
    private Random rand;
    private Face face;

    public Coin(Face face)
    {
        setFace(face);
        rand = new Random(); //initialization of rand
    }

    public final Face getFace()
    {
        return face;
    }

    public final void setFace(Face face)
    {
        if(face != null)
        {
            this.face = face;
        }
        else
        {
            this.face = Face.HEAD;
        }
    }

    public void flip()
    {
        boolean result = rand.nextBoolean(); //nextBoolean return 0 or 1 - Head is 0 and Tail is 1
        if(!result)
        {
            face = Face.HEAD;
        }
        else
        {
            face = Face.TAIL;
        }
    }

    public boolean isHeads()
    {
        return face == Face.HEAD;
    }

    @Override
    public String toString()
    {
        return face.toString();
    }
}
