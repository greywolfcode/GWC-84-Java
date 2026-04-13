package Menus.CalcMenus;

//import standard libraries
import java.util.Stack;

//import GWC_84_Java stuff
import GWC_84_Java.Data;

//import base Menu 
import Menus.ErrorMenu;

public class NoConfigError extends ErrorMenu
{
    public NoConfigError(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        
        //----set up error----
        
        setErrorName("   No Config Detected:    ");
        String[] options ={"Shut Down", " Continue"};
                
        String[] message = {"SaveData.conf is missing or",         
                            "corrupted. Please place it",          
                            "in the main directory or ",
                            "continue without loading save"};
    }
    
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
            case "w", "s":                 
                moveHandeler(event);                
                break;             
            default:                 
                break;         
        }
    }
}