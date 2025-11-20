import java.util.Stack;
import java.util.HashMap;

public class Calculator 
{
    private String state;
    private Menu currentMenu;
    private Menu prevMenu;
    private HashMap<String, Menu> menus;
    private Data data;
    private Stack<String> events;
    
    
    public Calculator()
    {
        state = "main";
        data = new Data();
        events = new Stack<String>();
        currentMenu = new MainMenu(data, events);
        //add all menus to hashmap
        menus = new HashMap<String, Menu>();
        menus.put("MainMenu", currentMenu);
        menus.put("SyntaxError", new SyntaxError(data, events));
        menus.put("DivideByZeroError", new DivideByZeroError(data, events));
    }
    public boolean handleInput(String input)
    {
        //set enter mode to 2nd or alpha
        if (input.equals("2nd"))
        {
            if (state.equals("2nd"))
            {
                state = "main";
            }
            else
            {
                state = "2nd";
            }
        }
        else if (input.equals("alp"))
        {
            if (state.equals("alp"))
            {
                state = "main";
            }
            else
            {
                state = "alp";
            }
        }
        //check if need to turn off calculator
        else if (state.equals("2nd"))
        {
            if (input.equals("on") || input.equals("off"))
            {
                return true;
            }
        }
        //run menu event handler
        else
        {
            currentMenu.eventHandeler(state, input);
        }
        //handle events
        handleEvents();
        //rerender screen
        clearScreen();
        currentMenu.renderScreen();
        return false;
    }
    private void clearScreen()
    {
        for(int i = 0; i<8; i++)
        {
            CursorControl.goTo(3, 5+i);
            System.out.print("                           ");
        }
    }
    private void handleEvents()
    {
        String event;
        String[] eventData;
        //loop through all events
        while (events.size() > 0)
        {
           event = events.pop();
           eventData = event.split(" ");
           switch (eventData[0])
           {
                case "switch":
                    switchMenu(eventData[1]);
                    break;
                case "prevMenu":
                    switchMenu(prevMenu);
                    break;
                default:
                    break;
           }
        }
    }
    /**
     * Switches menu to new menu
     * Overloaded to take either string of name or menu object
     * as the input
     */
    private void switchMenu(String menu)
    {
        prevMenu = currentMenu;
        currentMenu = menus.get(menu);
        currentMenu.onLoad();
    }
    private void switchMenu(Menu menu)
    {
        prevMenu = currentMenu;
        currentMenu = menu;
        currentMenu.onLoad();
    }
}