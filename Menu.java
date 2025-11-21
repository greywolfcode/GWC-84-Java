import java.util.Stack;

public abstract class Menu
{
    //protected as classes will need to make more complecated modifications to this
    protected String menuType = "action"; //tells if menu can have actions done in it
    protected Data data;
    protected String[] screen = {"", "", "", "", "", "", "", ""};
    protected Stack<String> globalEvents; //allows events to be sent to main calculator
    
    public abstract void eventHandeler(String state, String event);
    
    public abstract void onLoad(); //runs every time current menu is changed to this menu
    
    public void renderScreen()
    {
        for(int i=0; i<8; i++)
        {
            CursorControl.goTo(3, 5+i);
            System.out.print(screen[i]);
        }
    }
    public String getType()
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
}