package Menus;

import java.util.Stack;
import java.util.ArrayList;

import GWC_84_Java.Menu;
import GWC_84_Java.Data;
import GWC_84_Java.Calculate;

//import MathObject libraries
import MathObjects.MathObject;
import MathObject.Decimal;

public class MainMenu extends Menu
{
    private ArrayList<MathObject> currentLine = new ArrayList<>();
    private int cursorLocation = 0; //stores where in the block the cursor is
    private int currentBlock = 0; //stores which segment for really long blocks
    private int historyLine = 0; //stores how many lines of history there are
    
    public MainMenu(Data storage, Stack<String> events)
    {
        setMenuType("action");
        data = storage;
        setGlobalEvents(events);
    }
    public void onLoad()
    {
        String returnValue = data.getReturn();
        switch (returnValue)
        {
            case "goto":
                currentLine = data.getHistory(0)[0];
                updateScreen();
                break;
            default:
                break;
        }
    }
    public void onUnload(){}
    public void eventHandeler(String state, String event)
    {
        if (state.equals("main"))
        {
            handelerMain(event);
        }
        else if (state.equals("2nd"))
        {
            handeler2nd(event);
        }
        cursorLocation++;
        //update screen
        updateScreen();
    }
    private void handelerMain(String event)
    {
        switch (event)
        {
            //values that can be in a decimal
            case "temp_value_for_figuring_out_logic_will_be_made_to_work_later"
            {
                //if possible, add to current Decimal object
                if currentLine.get(currentLine.size() - 1).getType().equals("Decimal")
                {
                    currentLine.get(currentLine.size()-1).add;
                }
                //creat new object when required
                else
                {
                     currentLine.add(Decimal("1"));
                }
            }
            case "1":
                currentLine.append(Decimal(1));
                break;
            case "2":
                currentLine.append(Decimal(2));
                break;
            case "3":
                currentLine.append(Decimal(3));
                break;
            case "4":
                currentLine.append(Decimal(4));
                break;
            case "5":
                currentLine.append(Decimal(5));
                break;
            case "6":
                currentLine.append(Decimal(6));
                break;
            case "7":
                currentLine.append(Decimal(7));
                break;
            case "8":
                currentLine.append(Decimal(8));
                break;
            case "9":
                currentLine.append(Decimal(9));
                break;
            case "0":
                currentLine.append(Decimal(0));
                break;
            case ".":
                currentLine.append(".");
                break;
            case "-":
                currentLine.append("-");
                break;
            //operators. using u200b zero width space for sectioning purposes
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
            case "^":
                currentLine.append("\u200b^\u200b");
                break;
            case ")":
                currentLine.append("\u200b)\u200b");
                break;
            //special operators

            //functions. useing u200d zero width joiner to indicate that the parenthesis is attached to a function
            case "sin":
                currentLine.append("\u200bsin\u200b(\u200d\u200b");
                break;
            case "cos":
                currentLine.append("\u200bcos\u200b(\u200d\u200b");
                break;
            case "tan":
                currentLine.append("\u200btan\u200b(\u200d\u200b");
                break;
            case "log":
                currentLine.append("\u200blog\u200b(\u200d\u200b");
                break;
            case "ln":
                currentLine.append("\u200bln\u200b(\u200d\u200b");
                break;
            case "clr":
                if (currentLine.length() > 0)
                {
                    currentLine.setLength(0);
                }
                else
                {
                    historyLine = 0;
                    clearScreen();
                }
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
                        pushEvent("switch SyntaxError"); //add command to switch the menu
                    }
                    else if(value.equals("div/0"))
                    {
                        value = "DIV/0";
                        pushEvent("switch DivideByZeroError");
                    }
                    data.addHistory(new String[]{currentLine.toString(), value});
                    currentLine.clear(); 
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
    }
    private void handeler2nd(String event)
    {
        switch (event)
        {
            //special numbers
            case "e":
                currentLine.append("e");
                break;
            case "pi", "PI", "Pi", "π":
                currentLine.append("π");
                break;
            //functions
            case "sqrt", "√":
                currentLine.append("\u200b√\u200b(\u200d\u200b");
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