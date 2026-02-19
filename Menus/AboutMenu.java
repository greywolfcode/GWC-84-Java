package Menus;

import java.util.Stack; 
import GWC_84_Java.Data;

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
        screen[0] = "GWC-84 Java";
        
        screen[2] = "Console only graphing";
        screen[3] = "calculator";
        
        screen[5] = "Repository:";
        screen[6] = "https://github.com/";
        screen[7] = "greywolfcode/GWC-84-Java";
    }
}