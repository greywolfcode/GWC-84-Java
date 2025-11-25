package Menus;

import java.util.Stack;
import GWC_84_Java.Menu;
import GWC_84_Java.Data;

public class MathMenu extends Menu
{
    
    
    public MathMenu(Data storage, Stack<String> events)
    {
        menuType = "return";
        data = storage;
        globalEvents = events;
    }
    public void onLoad()
    {
        screen[0] = "hI!";
    }
    public void onUnload(){}
    public void eventHandeler(String state, String event)
    {
        switch (event)
        {
            case "clr":
                globalEvents.push("prevMenu");
                break;
        }
    }
}