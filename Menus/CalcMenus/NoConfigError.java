package Menus.CalcMenus;

import java.util.Stack;
import GWC_84_Java.Data;
import ConsoleControl.Colour;

//import base Menu 
import Menus.Menu;

public class NoConfigError extends Menu
{
    private int cursorLocation = 0;
    
    public NoConfigError(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        //predefine screen
        screen[0] = "   No Config Detected:    ";
        screen[1] = Colour.invert("1:") + "Shut Down";
        screen[2] = "2: Continue";
        screen[3] = "___________________________";         
        screen[4] = "SaveData.conf is missing or";         
        screen[5] = "corrupted. Please place it";          
        screen[6] = "in the main directory or ";
        screen[7] = "continue without loading save";
    }
    
    public void onLoad(String cursorState)
    {
        cursorLocation = 1;
        updateScreen();
    }
    public void onUnload(){}
    
    public void eventHandeler(String state, String event, String cursor)
    {
        switch (event)         
        {             
            case "1":                 
                pushEvent("off");                 
                break;             
            case "2":                 
                pushEvent("switch MainMenu");                 
                break;             
            case "ent":
                if (cursorLocation == 0)
                {
                    pushEvent("off");
                }
                else
                {
                    pushEvent("switch MainMenu");  
                }
                break;             
            case "clr":                 
                pushEvent("switch MainMenu");                 
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
    private void updateScreen()     
    {         
        if (cursorLocation == 0)         
        {             
            screen[1] = Colour.invert("1:") + " Shut Down";             
            screen[2] = "2: Continue";         
        }         
        else         
        {             
            screen[1] = "1: Shut Down";             
            screen[2] = Colour.invert("2:") + " Continue";         
        }     
    }
}