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
            //1st row
            System.out.println("┃"+ Colour.rgb("stp",0,130,230)+Colour.rgb("f1",99,184,125)+" "+Colour.rgb("tbl",0,130,230)+Colour.rgb("f2",99,184,125)+" "+
                                Colour.rgb("fmt",0,130,230)+Colour.rgb("f3",99,184, 125)+" "+Colour.rgb("clc",0,130,230)+Colour.rgb("f4",99,184,125)+" "+
                                Colour.rgb("tbl",0,130,230)+Colour.rgb("f5",99,184,125)+ "┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("y =");
            renderButtonMiddle("win");
            renderButtonMiddle("zom");
            renderButtonMiddle("trc");
            renderButtonMiddle("grp");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtomBottomX5();
            System.out.println("\b┃");
            //2nd row
            System.out.print("┃      "+Colour.rgb("qut", 0, 130, 230)+"  "+Colour.rgb("ins",0,130,230));
            System.out.println("               ┃");
            System.out.print("┃");
            renderButtonTopRGB(0,130,230);
            renderButtonTop();
            renderButtonTop();
            System.out.println("           ┃");
            System.out.print("┃");
            renderButtonMiddleRGB("2nd", 0, 130, 230);
            renderButtonMiddle("mod");
            renderButtonMiddle("del");
            System.out.print("     🞁     ");
            System.out.println("┃");
            System.out.print("┃");
            renderButtonBottomRGB(0, 130, 230);
            renderButtonBottom();
            renderButtonBottom();
            System.out.println("           ┃");
            //3rd row
            System.out.print("┃" +Colour.rgb("Alk",0,130,230)+"   " +Colour.rgb("lnk",0,130,230)+Colour.rgb(" ⁄",99,184,125)+ " "+Colour.rgb("lst",0,130,230));
            System.out.print("    "+Colour.rgb("🡀", 0, 130, 230)+"🞀  ●  🞂" + Colour.rgb("🡂", 0, 130, 230));
            System.out.println(" ┃");
            System.out.print("┃");
            renderButtonTopRGB(99, 184, 125);
            renderButtonTop();
            renderButtonTop();
            System.out.println("           ┃");
            System.out.print("┃");
            renderButtonMiddleRGB("alp", 99, 184, 125);
            renderButtonMiddle(" x ");
            renderButtonMiddle("stt");
            System.out.println("     🞃     ┃"); 
            System.out.print("┃");
            renderButtonBottomRGB(99, 184, 125);
            renderButtonBottom();
            renderButtonBottom();
            System.out.println("           ┃");
            //4th row
            System.out.print("┃"+Colour.rgb("tst",0,130,230)+Colour.rgb(" A",99,184,125)+" "+Colour.rgb("ang",0, 130, 230)+ Colour.rgb(" B",99,184,125)+ " "+Colour.rgb("dit",0,130,230));
            System.out.println("              ┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("mth");
            renderButtonMiddle("app");
            renderButtonMiddle("pgm");
            renderButtonMiddle("var");
            renderButtonMiddle("clr");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtomBottomX5();
            System.out.println("\b┃");
            //5th row
            System.out.print("┃"+Colour.rgb("mrx",0,130,230)+Colour.rgb(" D",99, 184,125)+" "+Colour.rgb(" sn⁻¹",0,130,230)+ Colour.rgb("E",99,184,125)+" "+Colour.rgb("cs⁻¹",0,130,230)+Colour.rgb("F", 99, 184, 125)+" "
                             +Colour.rgb("tn⁻¹", 0, 130, 230) +Colour.rgb("G",99,184,125)+" "+Colour.rgb("π",0,130,230)+Colour.rgb(" H",99,184,125));
        
            System.out.println("\b")
        }
    }
    private static void renderButtonTop()
    {
        System.out.print("┌───┐ ");
    }
    private static void renderButtonTopRGB(int r, int g, int b)
    {
        System.out.print(Colour.rgb("┌───┐ ", r, g, b));
    }
    private static void renderButtonMiddle(String text)
    {
        System.out.print("│" + text + "│ "); 
    }
    private static void renderButtonMiddleRGB(String text, int r, int g, int b)
    {
        System.out.print(Colour.rgb("│"+text+"│ ", r, g, b));
    }
    private static void renderButtonBottom()
    {
        System.out.print("└───┘ ");
    }
    private static void renderButtonBottomRGB(int r, int g, int b)
    {
        System.out.print(Colour.rgb("└───┘ ", r, g, b));
    }
    private static void renderButtonTopX5()
    {
        renderButtonTop();
        renderButtonTop();
        renderButtonTop();
        renderButtonTop();
        renderButtonTop();
    }
    private static void renderButtomBottomX5()
    {
        renderButtonBottom();
        renderButtonBottom();
        renderButtonBottom();
        renderButtonBottom();
        renderButtonBottom();
    }
}