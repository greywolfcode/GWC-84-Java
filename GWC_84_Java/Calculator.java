package GWC_84_Java;

//import java stuff
import java.util.Stack;
import java.util.HashMap;
//import menus
import Menus.Menu;
import Menus.MainMenu;
import Menus.SyntaxError;
import Menus.DivideByZeroError;
import Menus.DomainError;
import Menus.NonRealError;
import Menus.MathMenu;
import Menus.NumMenu;
import Menus.CmplxMenu;
import Menus.ProbMenu;
import Menus.FracMenu;
//import console control stuff
import ConsoleControl.Cursor;
import ConsoleControl.Colour;

public class Calculator 
{
    private String state;
    private String cursorState;
    private Menu currentMenu;
    private Menu prevMenu;
    private HashMap<String, Menu> menus;
    private Data data;
    private Stack<String> events;
    
    public Calculator()
    {
        state = "main";
        cursorState = "N";
        data = new Data();
        events = new Stack<String>();
        currentMenu = new MainMenu(data, events);
        //add all menus to hashmap
        menus = new HashMap<String, Menu>();
        menus.put("MainMenu", currentMenu);
        menus.put("SyntaxError", new SyntaxError(data, events));
        menus.put("DivideByZeroError", new DivideByZeroError(data, events));
        menus.put("DomainError", new DomainError(data, events));
        menus.put("NonRealError", new NonRealError(data, events));
        menus.put("MathMenu", new MathMenu(data, events));
        menus.put("NumMenu", new NumMenu(data, events));
        menus.put("CmplxMenu", new CmplxMenu(data, events));
        menus.put("ProbMenu", new ProbMenu(data, events));
        menus.put("FracMenu", new FracMenu(data, events));
        //update ui on startup
        updateTopBar();
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
            updateTopBar();
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
            updateTopBar();
        }
        else if (input.equals("mth"))
        {
            events.push("switch MathMenu");
        }
        else
        {
            //check if need to turn off calculator
            if (input.equals("on") || input.equals("off") && state.equals("2nd"))
            {
                return true;
            }
            //check if need to change cursor state
            else if (input.equals("ins") && state.equals("2nd"))
            {
                if (cursorState.equals("N"))
                {
                    cursorState = "I";
                }
                else
                {
                    cursorState = "N";
                }
            }
            //reset cursor state if moving cursor
            if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d"))
            {
                cursorState = "N";
            }
            //run menu event handler
            currentMenu.eventHandeler(state, input, cursorState);
            state = "main"; //reset back to main if any other button is pressed
            updateTopBar();
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
            Cursor.goTo(3, 5+i);
            System.out.print("                           ");
        }
    }
    private void updateTopBar()
    {
        Cursor.goTo(3, 4);
        System.out.print(Colour.bgRGB("RAD", 200, 200, 200));
        System.out.print(Colour.bgRGB(" CL", 200, 200, 200)); //only classic mode is an option
        System.out.print(Colour.bgRGB(" " + cursorState, 200, 200, 200));
        Cursor.goTo(28, 4);
        switch (state)
        {
            case "2nd":
                System.out.print(Colour.bgRGB("🡩", 200, 200, 200));
                break;
            case "alp":
                System.out.print(Colour.bgRGB("A", 200, 200, 200));
                break;
            default:
                System.out.print(Colour.bgRGB(" ", 200, 200, 200));
                break;
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
                    //check for flags
                    if (eventData[1].equals("noChangePrev"))
                    {
                        switchMenuNoChangePrev(eventData[2]);
                        break;
                    }
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
        prevMenu.onUnload();
        currentMenu = menus.get(menu);
        currentMenu.onLoad(cursorState);
    }
    private void switchMenu(Menu menu)
    {
        prevMenu = currentMenu;
        prevMenu.onUnload();
        currentMenu = menu;
        currentMenu.onLoad(cursorState);
    }
    /**
     * Switches menu to new menu,
     * but doesn't change the previous menu
     */
    private void switchMenuNoChangePrev(String menu)
    {
        currentMenu = menus.get(menu);
        currentMenu.onLoad(cursorState);
    }
    private void switchMenuNoChangePrev(Menu menu)
    {
        currentMenu = menu;
        currentMenu.onLoad(cursorState);
    }
}