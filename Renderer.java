public class Renderer
{
    private Renderer(){}
    
    public static void render()
    {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃         GWC-84 Java         ┃");
        renderScreen();
        renderKeypad("main");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
    private static void renderScreen()
    {
        String l = "│                           │";
        System.out.println("┃┌───────────────────────────┐┃");
        for (int i=0; i<8; i++)
        {
            System.out.println("┃"+l+"┃");
        }
        System.out.println("┃└───────────────────────────┘┃");
    }
    private static void renderKeypad(String setting)
    {
        if (setting.equals("main"))
        {
            //This massive line prints the coloured top row
            System.out.println("┃"+ Colour.rgb("stp",0,130,230)+Colour.rgb("f1",99,184,125)+" "+Colour.rgb("tbl",0,130,230)+Colour.rgb("f2",99,184,125)+" "+
                                Colour.rgb("fmt",0,130,230)+Colour.rgb("f3",99,184, 125)+" "+Colour.rgb("clc",0,130,230)+Colour.rgb("f4",99,184,125)+" "+
                                Colour.rgb("tbl",0,130,230)+Colour.rgb("f5",99,184,125)+ "┃");
            System.out.print("┃");
            renderButtonTop();
            renderButtonTop();
            renderButtonTop();
            renderButtonTop();
            renderButtonTop();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("y =");
            renderButtonMiddle("win");
            renderButtonMiddle("zom");
            renderButtonMiddle("trc");
            renderButtonMiddle("grp");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottom();
            renderButtonBottom();
            renderButtonBottom();
            renderButtonBottom();
            renderButtonBottom();
            System.out.println("\b┃");
        }
    }
    private static void renderButtonTop()
    {
        System.out.print("┌───┐ ");
    }
    private static void renderButtonTopRGB(int r, int g, int b)
    {
        System.out.print(Colour.rgb("┌───┐", r, g, b));
    }
    private static void renderButtonMiddle(String text)
    {
        System.out.print("│" + text + "│ "); 
    }
    private static void renderButtonMiddleRGB(String text)
    {
        
    }
    private static void renderButtonBottom()
    {
        System.out.print("└───┘ ");
    }
    private static void renderButtomBottomRGB(int r, int g, int b)
    {
        System.out.print(Colour.rgb("└───┘", r, g, b));
    }
}