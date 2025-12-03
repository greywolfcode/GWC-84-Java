package Menus;

import java.util.Stack;
import GWC_84_Java.Menu;
import GWC_84_Java.Data;
import ConsoleControl.Colour;

public class MathMenu extends Menu
{
    private int cursorPos = 0;
    private int topLine = 0;
    //stores all menu items
    private String[] options = {"1: 🞂Frac","2: 🞂Dec","3: ³", "4: ∛", "5: ᕽ√", "6: fMin(", "7: fMax(", "8: nDeriv(", "9: fnInt(", "0: sum ∑", "A: LOGBASE(", "B: piecewise(", "C: Num Solver"};
    
    public MathMenu(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
    }
    public void onLoad()
    {
        screen[0] = Colour.invert("MATH") + " NUM CMPLX PROB FRAC";
        updateScreen();
    }
    public void onUnload(){}
    public void eventHandeler(String state, String event)
    {
        switch (event)
        {
            case "w":
                if (cursorPos == 0)
                {
                    cursorPos = options.length - 1;
                    topLine = cursorPos - 6;
                }
                else if (cursorPos == topLine)
                {
                    cursorPos -= 1;
                    topLine -= 1;
                }
                else
                {
                    cursorPos -= 1;
                }

                break;
            case "s":
                if (cursorPos == options.length - 1)
                {
                    cursorPos = 0;
                    topLine = 0;
                }
                else if (cursorPos == topLine + 6)
                {
                    cursorPos += 1;
                    topLine += 1;
                }
                else
                {
                    cursorPos += 1;
                }
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "ent":
                break;
        }
        updateScreen();
    }
    private void updateScreen()
    {
        for (int i=0; i<7; i++)
        {
            if (topLine + i == cursorPos)
            {
                screen[i+1] = Colour.invert(options[topLine+i].substring(0, 2)) + options[topLine+i].substring(2);
            }
            else
            {
                screen[i+1] = options[topLine+i];
            }
        }
    }
}