/**
 * Class creates string for colour output in console
 */
public class Colour 
{
    private Colour(){}
    
    /**
     * Creates and returns Strings for RGB colour
     * Takes line and RGB colour values as input
     */
    public static String rgb(String line, int r, int g, int b)
    {
        return "\033[38;2;" + r + ";" + g + ";" + b + "m" + line + "\033[0m";
    }
}