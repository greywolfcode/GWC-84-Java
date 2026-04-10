package Menus.CalcMenus;


//import standard libraries
import java.util.Stack; 

//import GWC_84_Java stuff
import GWC_84_Java.Data;

//import ConsoleControl stuff
import ConsoleControl.Colour;

//import base Menu
import Menus.Menu;

public class AboutMenu extends Menu
{
    public AboutMenu(Data storage, Stack<String> events)
    {
        setMenuType("info");
        data = storage;
        setGlobalEvents(events);
        //this menu never changes, so this is only called once
        updateScreen();
    }
    
    public void onLoad(String cursor){}
    public void onUnload(){}
    
    public void eventHandeler(String state, String event, String cursor)
    {
        if (event.equals("clr"))
        {
            pushEvent("switch MainMenu");
        }
    }
    private void updateScreen()
    {
        screen[0] = "       " + Colour.invert("GWC-84 Java") + "       ";
        
        screen[1] = "Console only graphing";
        screen[2] = "calculator";
        
        screen[4] = "Repository:";
        screen[5] = "https://github.com/";
        screen[6] = "greywolfcode/GWC-84-Java";
        screen[7] = "License: MIT";
    }
}