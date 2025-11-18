import java.util.Stack()

public class Calculator 
{
    private String state;
    private Menu currentMenu;
    private Data data;
    private Stack<String> events;
    
    public Calculator()
    {
        state = "main";
        data = new Data();
        currentMenu = new MainMenu(data);
        events = new Stack();
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
           switch eventData[0]
           {
                case "switch":
                    break;
           }
        }
    }
}