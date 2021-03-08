package monetarycoin;

public enum Face
{
    HEAD("HEAD"), TAIL("TAIL");

    private final String face;

    Face(String constants) //this constructor is private
    {
        if(constants != null)
        {
            this.face = constants;
        }
        else
        {
            this.face = "HEAD";
        }
    }

    @Override
    public String toString()
    {
        return String.format("Face: %s", face);
    }
}
