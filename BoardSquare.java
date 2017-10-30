public class BoardSquare
{
    private String label;
    private int coordX;
    private int coordY;
    
    public BoardSquare()
    {
        label = "";
        coordX = 0;
        coordY = 0;
    }
    
    public BoardSquare(String lab, int i, int j)
    {
        coordX = i;
        coordY = j;
        label = lab;
    }
    
    // get methods
    public String getLabel()                { return label; }
    public int getX()                       { return coordX; }
    public int getY()                       { return coordY; }
    
    // set methods
    public void setLabel(String lab)        { label = lab; }
    public void setX(int i)                 { coordX = i; }
    public void setY(int j)                 { coordY = j; }
}