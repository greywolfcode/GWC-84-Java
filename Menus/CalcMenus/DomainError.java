package Menus.CalcMenus;

//import standard libraries
import java.util.Stack;

//import GWC_84_Java stuff
import GWC_84_Java.Data;
import GWC_84_Java.Message;

//import base Menu 
import Menus.ErrorMenu;

public class DomainError extends ErrorMenu
{
    public DomainError(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        //----set up error----
        
        setErrorName("      DOMAIN  ERROR:      ");
        
        String[] options = {"Quit", "Goto"};
        setOptions(options);

        String[] message = {"Value entered is not",
                            "allowed in the function", 
                            "or command"};
        setMessage(message);
    }
    public void eventHandeler(String state, String event, String cursorState)
    {
        switch (event)
        {
            case "1":
                pushEvent("prevMenu");
                break;
            case "2":
                data.setReturn(new Message("goto"));
                pushEvent("prevMenu");
                break;
            case "ent":
                if (cursorLocation == 1)
                {
                    data.setReturn(new Message("goto"));
                }
                pushEvent("prevMenu");
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "w", "s":
                moveHandeler(event);
                break;

            default:
                break;
        }
    }
}