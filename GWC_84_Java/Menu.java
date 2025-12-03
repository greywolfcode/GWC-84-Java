package GWC_84_Java;

import java.util.Stack;
import ConsoleControl.Cursor;


public abstract class Menu
{
    //protected as classes will need to make more complecated modifications to these
    protected Data data;
    protected String[] screen = {"", "", "", "", "", "", "", ""}; //get 8 lines for screen
    //These variables don't require complicated operations
    private String menuType = "action"; //tells if menu can have actions done in it
    private Stack<String> globalEvents; //allows events to be sent to main calculator
    
    public abstract void eventHandeler(String state, String event);
    
    public abstract void onLoad(); //runs every time current menu is changed to this menu
    
    public abstract void onUnload(); //runs every time current menu is changed from this menu
    
    public void renderScreen()
    {
        for(int i=0; i<8; i++)
        {
            Cursor.goTo(3, 5+i);
            System.out.print(screen[i]);
        }
    }
    public String getMenuType()
    {
        return menuType;
    }
    protected void clearScreen()
    {
        for (int i=0; i<8; i++)
        {
            screen[i] = "";
        }
    }
    protected void setMenuType(String type)
    {
        menuType = type;
    }
    protected void setGlobalEvents(Stack<String> event)
    {
        globalEvents = event;
    }
    protected void pushEvent(String event)
    {
        globalEvents.push(event);
    }
}