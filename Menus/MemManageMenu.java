package Menus;

//import standard libraries
import java.util.Stack;

//import custom libraries
import GWC_84_Java.Data;
import ConsoleControl.Colour;

public class MemManageMenu extends Menu
{
    
    private int cursorPos = 1;
    private int topLine = 0;
    private String[] lines;
    
    public MemManageMenu(Data storage, Stack<String> events)
    {
        setMenuType("action");
        data = storage;
        setGlobalEvents(events);
        lines = new String[]{"Default Save Path:", "none", "Save 1:", "none", "Save 2:", "none", "Save 3:", "none", "Save 4:", "none", "Save 5", "none", "Save 6:", "none"};
        updateScreen();
    }
    
    public void onLoad(String cursor)
    {
        topLine = 0;
        cursorPos = 1;
        updateScreen();
    }
    public void onUnload(){}
    
    
    public void eventHandeler(String state, String event, String cursor)
    {
        switch (event)
        {
            case "w":                 
                if (cursorPos == 1)                 
                {                     
                    cursorPos = lines.length - 1;  
                    topLine = cursorPos - 6;
                }                 
                else if (cursorPos == topLine)                 
                {                     
                    cursorPos-=2;                     
                    topLine = cursorPos - 1;                 
                }                 
                else if (cursorPos == topLine + 1)
                {
                    cursorPos -= 2;
                    topLine = cursorPos - 1;
                }
                else                 
                {                     
                    cursorPos-=2;                 
                }                 
                break;             
            case "s":                 
                if (cursorPos == lines.length - 1)                 
                {                     
                    cursorPos = 1;                     
                    topLine = 0;                 
                }                 
                else if (cursorPos == topLine + 5)                 
                {                     
                    cursorPos+=2;                     
                    topLine+=2;                 
                }                 
                else                 
                {                     
                    cursorPos+=2;                 
                }                 
                break;
        }
        updateScreen();
    }
    private void updateScreen()
    {
        for (int i=0; i<7; i+=1)             
        {                 
            if (topLine + i == cursorPos)                 
            {                     
                screen[i] = " " + Colour.invert(lines[topLine+i]);
                
            }                 
            else                 
            {                     
                screen[i] = " " + lines[topLine+i];   
                
            }             
        }
    }
}