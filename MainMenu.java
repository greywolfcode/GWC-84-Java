import java.lang.StringBuilder;

public class MainMenu extends Menu
{
    private StringBuilder currentLine = new StringBuilder();
    private int cursorLocation = 0;
    
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
                currentLine.append("1");
                break;
            case "2":
                currentLine.append("2");
                break;
            case "3":
                currentLine.append("3");
                break;
            case "4":
                currentLine.append("4");
                break;
            case "ent":
                if (currentLine.length() > 0)
                {
                    data.addHistory(new String[]{currentLine.toString(), " ".repeat(27-currentLine.length()) + currentLine.toString()});
                    currentLine.setLength(0); 
                }
                break;
            default:
                break;
        }
        //update screen
        updateScreen();
    }
    private void updateScreen()
    {
        //fill as many slots as possible with history
        int historyIndex = 0;
        for(int i=7; i>0; i-=2)
        {
            screen[i] = data.getHistory(historyIndex)[1];
            screen[i-1] = data.getHistory(historyIndex)[0];
            historyIndex++;
        }
        screen[6] = currentLine.toString();
        screen[7] = "";
    }
}