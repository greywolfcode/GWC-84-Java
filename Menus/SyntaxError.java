package Menus;

import java.util.Stack;
import GWC_84_Java.Menu;
import GWC_84_Java.Data;
import ConsoleControl.Colour;

public class SyntaxError extends Menu
{
    private int cursorLocation = 0; //0= Quit, 1 = Goto
    
    public SyntaxError(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        //set up error
        screen[0] = "      SYNTAX  ERROR:      ";
        screen[1] = Colour.invert("1:") + " Quit";
        screen[2] = "2: Goto";
        screen[3] = "___________________________";
        screen[4] = "Check all arguments";
        screen[5] = "Press + on menu"; 
        screen[6] = "  item for help";
    }
    public void eventHandeler(String state, String event)
    {
        switch (event)
        {
            case "1":
                pushEvent("prevMenu");
                break;
            case "2":
                data.setReturn("goto");
                pushEvent("prevMenu");
                break;
            case "ent":
                if (cursorLocation == 1)
                {
                    data.setReturn("goto");
                }
                pushEvent("prevMenu");
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "w":
                cursorLocation = 0;
                updateScreen();
                break;
            case "s":
                cursorLocation = 1;
                updateScreen();
                break;
            default:
                break;
        }
    }
    public void onLoad()
    {
        cursorLocation = 0; 
        updateScreen();
    }
    public void onUnload(){}
    private void updateScreen()
    {
        if (cursorLocation == 0)
        {
            screen[1] = Colour.invert("1:") + " Quit";
            screen[2] = "2: Goto";
        }
        else
        {
            screen[1] = "1: Quit";
            screen[2] = Colour.invert("2:") + " Goto";
        }
    }
}