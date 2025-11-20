import java.lang.StringBuilder;
import java.util.Stack;

public class MainMenu extends Menu
{
    private StringBuilder currentLine = new StringBuilder();
    private int cursorLocation = 0; //stores where in the block the cursor is
    private int currentBlock = 0; //stores which segment for really long blocks
    private int historyLine = 0; //stores how many lines of history there are
    
    public MainMenu(Data storage, Stack<String> events)
    {
        menuType = "action";
        data = storage;
        globalEvents = events;
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
            case "5":
                currentLine.append("5");
                break;
            case "6":
                currentLine.append("6");
                break;
            case "7":
                currentLine.append("7");
                break;
            case "8":
                currentLine.append("8");
                break;
            case "9":
                currentLine.append("9");
                break;
            case "0":
                currentLine.append("0");
                break;
            case ".":
                currentLine.append(".");
                break;
            case "-":
                currentLine.append("-");
                break;
            //using u200b zero width space for sectioning purposes
            case "+":
                currentLine.append("\u200b+\u200b");
                break;
            case "_", "−": //underscore so hyphen can be negative number
                currentLine.append("\u200b−\u200b");
                break;
            case "*", "×":
                currentLine.append("\u200b×\u200b");
                break;
            case "/", "÷":
                currentLine.append("\u200b÷\u200b");
                break;
            case "(":
                currentLine.append("\u200b(\u200b");
                break;
            case ")":
                currentLine.append("\u200b)\u200b");
                break;
            //functions us u200d zero width joiner to indicate that the parenthesis is attached to a function
            case "sin":
                currentLine.append("\u200bsin\u200b(\u200d\u200b");
                break;
            case "cos":
                currentLine.append("\u200bcos\u200b(\u200d\u200b");
                break;
            case "tan":
                currentLine.append("\u200btan\u200b(\u200d\u200b");
                break;
            case "^":
                currentLine.append("\u200b^\u200b");
                break;
            case "clr":
                currentLine.setLength(0);
                break;
            case "ent":
                //perform previous calculation if line in emtpy
                if (currentLine.length() == 0)
                {
                    currentLine.append(data.getHistory(0)[0]);
                }
                if (currentLine.length() > 0) //additonal check in case there is no history
                {
                    //get postfix
                    String value = Calculate.solveEquation(currentLine.toString());
                    //check for error
                    if (value.equals("error"))
                    {
                        value = "Error";
                        globalEvents.push("switch SyntaxError"); //add command to switch the menu
                    }
                    else if(value.equals("div/0"))
                    {
                        value = "DIV/0";
                        globalEvents.push("switch DivideByZeroError");
                    }
                    data.addHistory(new String[]{currentLine.toString(), value});
                    currentLine.setLength(0); 
                    if (historyLine < 6)
                    {
                        historyLine+=2;
                    }
                }
                break;
            default:
                cursorLocation--;
                break;
        }
        cursorLocation++;
        //update screen
        updateScreen();
    }
    public void onLoad()
    {
        String returnValue = data.getReturn();
        switch (returnValue)
        {
            case "goto":
                currentLine.append(data.getHistory(0)[0]);
                updateScreen();
                break;
            default:
                break;
        }
    }
    private void updateScreen()
    {
        //fill as many slots as possible with history
        int historyIndex = 0;
        for(int i=historyLine-2; i>=0; i-=2)
        {
            screen[i] = data.getHistory(historyIndex)[0];
            screen[i+1] = data.getHistory(historyIndex)[1];
            screen[i+1] = " ".repeat(27-screen[i+1].length()) + screen[i+1];
            historyIndex++;
        }
        screen[historyLine] = currentLine.toString();
        screen[historyLine + 1] = "";
    }
}