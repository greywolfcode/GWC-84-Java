package GWC_84_Java;

import ConsoleControl.Colour;

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
        String line = "│                           │"; //screen is 27 spaces wide
        System.out.println("┃┌───────────────────────────┐┃");
        System.out.println("┃│" + Colour.bgRGB("                           ", 200, 200, 200) + "│┃");
        for (int i=0; i<8; i++)
        {
            System.out.println("┃"+line+"┃");
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
            renderButtonBottomX5();
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
            renderButtonBottomX5();
            System.out.println("\b┃");
            //5th row
            System.out.print("┃"+Colour.rgb("mrx",0,130,230)+Colour.rgb(" D",99, 184,125)+" "+Colour.rgb(" sn⁻¹",0,130,230)+ Colour.rgb("E",99,184,125)+" "+Colour.rgb("cs⁻¹",0,130,230)+Colour.rgb("F", 99, 184, 125)+" "
                             +Colour.rgb("tn⁻¹", 0, 130, 230) +Colour.rgb("G",99,184,125)+" "+Colour.rgb("π",0,130,230)+Colour.rgb(" H",99,184,125));
            System.out.println(" ┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("x⁻¹");
            renderButtonMiddle("sin");
            renderButtonMiddle("cos");
            renderButtonMiddle("tan");
            renderButtonMiddle(" ^ ");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottomX5();
            System.out.println("\b┃");
            //6th row
            System.out.println("┃"+Colour.rgb("√",0,130,230)+Colour.rgb("   I",99,184,125)+" "+Colour.rgb("EE",0,130,230)+Colour.rgb("  J",99,184,125)+" "+Colour.rgb("{",0,130,230)+Colour.rgb("   K",99,184,125)+" "+
                                Colour.rgb("}",0,130,230)+Colour.rgb("   L", 99,184,125)+" "+Colour.rgb("e",0,130,230)+Colour.rgb("   M",99,184,125) + "┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("x ²");
            renderButtonMiddle(" , ");
            renderButtonMiddle(" ( ");
            renderButtonMiddle(" ) ");
            renderButtonMiddle(" ÷ ");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottomX5();
            System.out.println("\b┃");
            //7th row
            System.out.println("┃"+Colour.rgb("10ˣ",0,130,230)+Colour.rgb(" N",99,184,125)+" "+Colour.rgb("u",0,130,230)+Colour.rgb("   O",99,184,125)+" "+Colour.rgb("v",0,130,230)+Colour.rgb("   P",99,184,125)+" "+
                                Colour.rgb("w",0,130,230)+Colour.rgb("   Q",99,184,125)+" "+Colour.rgb("[",0,130,230)+Colour.rgb("   R",99,184,125)+"┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("log");
            renderButtonMiddle(" 7 ");
            renderButtonMiddle(" 8 ");
            renderButtonMiddle(" 9 ");
            renderButtonMiddle(" × ");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottomX5();
            System.out.println("\b┃");
            //8th row
            System.out.println("┃"+Colour.rgb("eˣ",0,130,230)+Colour.rgb("  S",99,184,125)+" "+Colour.rgb("L4",0,130,230)+Colour.rgb("  T",99,184,125)+" "+Colour.rgb("L5",0,130,230)+Colour.rgb("  U",99,184,125)+" "+
                                Colour.rgb("L6",0,130,230)+Colour.rgb("  V",99,184,125)+" "+Colour.rgb("]",0,130,230)+Colour.rgb("   W",99,184,125)+"┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("l n");
            renderButtonMiddle(" 4 ");
            renderButtonMiddle(" 5 ");
            renderButtonMiddle(" 6 ");
            renderButtonMiddle(" − ");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottomX5();
            System.out.println("\b┃");
            //9th row
            System.out.println("┃"+Colour.rgb("rcl",0,130,230)+Colour.rgb(" X",99,184,125)+" "+Colour.rgb("L1",0,130,230)+Colour.rgb("  Y",99,184,125)+" "+Colour.rgb("L2",0,130,230)+Colour.rgb("  Z",99,184,125)+" "+
                                Colour.rgb("L3",0,130,230)+Colour.rgb("  θ",99,184,125)+" "+Colour.rgb("mem",0,130,230)+Colour.rgb(" \"",99,184,125)+"┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("st⭢");
            renderButtonMiddle(" 1 ");
            renderButtonMiddle(" 2 ");
            renderButtonMiddle(" 3 ");
            renderButtonMiddle(" + ");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottomX5();
            System.out.println("\b┃");
            //10th row
            System.out.println("┃"+Colour.rgb("off",0,130,230)+"   "+Colour.rgb("cat",0,130,230)+Colour.rgb(" ⎵",99,184,125)+" "+Colour.rgb("𝑖",0,130,230)+Colour.rgb("   :",99,184,125)+" "+Colour.rgb("ans",0,130,230)+
                                Colour.rgb(" ?",99,184,125)+" "+Colour.rgb("ent",0,130,230)+Colour.rgb("sl",99,184,125)+"┃");
            System.out.print("┃");
            renderButtonTopX5();
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonMiddle("o n");
            renderButtonMiddle(" 0 ");
            renderButtonMiddle(" . ");
            renderButtonMiddle("(-)");
            renderButtonMiddle("ent");
            System.out.println("\b┃");
            System.out.print("┃");
            renderButtonBottomX5();
            System.out.println("\b┃");
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
    private static void renderButtonBottomX5()
    {
        renderButtonBottom();
        renderButtonBottom();
        renderButtonBottom();
        renderButtonBottom();
        renderButtonBottom();
    }
}