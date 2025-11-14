public abstract class Menu
{
    //protected as classes will need to make more complecated modifications to this
    protected String menuType; //tells if menu can have actions done in it
    protected Data data;
    protected String[] screen = {"1", "2", "3", "4", "5", "6", "7", "8"};
    
    public abstract void eventHandeler(String state, String event);
    
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
}