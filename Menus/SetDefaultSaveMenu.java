package Menus;


//import standard libraries
import java.util.Stack;


//import custom libraries
import GWC_84_Java.Data;
import ConsoleControl.Colour;


public class SetDefaultSaveMenu extends Menu
{
    
    private int cursorPos = 1;
    private int topLine = 0;
    private int selectedLine = 0; //for tracking which save/if default save path is selected
    private int currentSelected = 0;
    private String[] lines;
    
    public SetDefaultSaveMenu(Data storage, Stack<String> events)
    {
        setMenuType("action");
        data = storage;
        setGlobalEvents(events);
        lines = new String[]{"Save 1:", "none", "Save 2:", "none", "Save 3:", "none", "Save 4:", "none", "Save 5", "none", "Save 6:", "none", ""};
        updateScreen();
    }
    
    public void onLoad(String cursor)
    {
        topLine = 0;
        cursorPos = 1;
        selectedLine = 0;
        updatePaths();
        updateScreen();
    }
    public void onUnload(){}
    
    public void eventHandeler(String state, String event, String cursor)
    {
        if (state.equals("main"))
        {
            eventHandelerMain(event);
        }
        else if (state.equals("2nd"))
        {
            eventHandeler2nd(event);
        }
        updateScreen();
    }
    public void eventHandelerMain(String event)
    {
        switch (event)
        {
            case "w", "ww", "www": //prevent overwriting path with typos; these are likely not file names that will be used               
                if (cursorPos == 1)                 
                {                     
                    cursorPos = lines.length - 2; //extra line to make scroll work properly  
                    topLine = cursorPos - 6;
                    selectedLine = 6;
                }                 
                else if (cursorPos == topLine)                 
                {                     
                    cursorPos-=2;                     
                    topLine = cursorPos - 1;  
                    selectedLine--;
                }                 
                else if (cursorPos == topLine + 1)
                {
                    cursorPos -= 2;
                    topLine = cursorPos - 1;
                    selectedLine--;
                }
                else                 
                {                     
                    cursorPos-=2;      
                    selectedLine--;
                }                 
                break;             
            case "s", "ss", "sss":             
                if (cursorPos == lines.length - 2) //see 42                
                {                     
                    cursorPos = 1;                     
                    topLine = 0; 
                    selectedLine = 0;
                }
                else if (cursorPos == topLine + 5)                 
                {                     
                    cursorPos+=2;                     
                    topLine+=2;  
                    selectedLine++;
                }                 
                else                 
                {                     
                    cursorPos+=2;  
                    selectedLine++;
                }                 
                break;
            case "clr":
            {
                pushEvent("switch MainMenu");
                break;
            }
            case "ent":
                {
                    data.setDefaultSave(selectedLine);
                    currentSelected = selectedLine;
                    pushEvent("switch MainMenu");
                    break;
                }
        }
    }
    private void eventHandeler2nd(String event)
    {
        switch (event)
        {
            case "qut", "quit":
                pushEvent("switch MainMenu");
                break;
        }
    }
    private void updateScreen()
    {
        for (int i=0; i<7; i+=1)             
        {                 
            if (topLine + i == cursorPos)                 
            {                     
                screen[i] = " " + Colour.invert(lines[topLine+i]);
            }   
            else if ((topLine+i+1) / 2.0 == currentSelected) //will be even number since offset by twos
            {
                screen[i] = " " + Colour.bgRGB(lines[topLine+i], 100, 100, 100);
            }
            else                 
            {                     
                screen[i] = " " + lines[topLine+i];   
            }  
        }
    }
    //update paths with data from Data
    private void updatePaths()
    {
        for (int i=0; i<6; i++)
        {
            lines[i*2+1] = data.getPath(i); // every second piece, offset by 1 to be odds
        }
        currentSelected = data.getDefaultSave() + 1; //get which one should be highlighted. Wierd off by one error
    }
}