public class MainMenu extends Menu
{
    private String currentLine;
    
    public MainMenu(Data storage)
    {
        String menuType = "action";
        data = storage;
    }
    public void eventHandeler(String state, String event)
    {
        switch (event)
        {
            case "1":
                screen[0] += "1";
        }
    }
}