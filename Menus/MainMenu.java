package Menus;

import java.util.Stack;
import java.util.ArrayList;

import GWC_84_Java.Menu;
import GWC_84_Java.Data;
import GWC_84_Java.Calculate;

//import MathObject classes
import MathObjects.MathObject;
//numbers:
import MathObjects.Numbers.Decimal;
//operators:
import MathObjects.Operators.Plus;
import MathObjects.Operators.Minus;
import MathObjects.Operators.Multiply;
import MathObjects.Operators.Divide;
import MathObjects.Operators.Exponent;
//functions
import MathObjects.Functions.Sin;
import MathObjects.Functions.Cos;
import MathObjects.Functions.Tan;
import MathObjects.Functions.Log;
import MathObjects.Functions.Ln;
import MathObjects.Functions.Sqrt;
//groupers:
import MathObjects.Groupers.RoundLeft;
import MathObjects.Groupers.RoundRight;
//symbols:
import MathObjects.Symbols.Pi;
import MathObjects.Symbols.EulersNumber;
import MathObjects.Symbols.Ans;

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
                currentLine = data.getHistory(0).get(0);
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
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".":
                //if possible, add to current Decimal object
                if (currentLine.size() > 0 && currentLine.get(currentLine.size() - 1).getType().equals("Decimal"))
                {
                    currentLine.get(currentLine.size() - 1).add(event);
                }
                //creat new object when required
                else
                {
                     currentLine.add(new Decimal(event));
                }
                break;
            //handle negative seperatly since it has to go at the start of the numbe-
            case "-":
                if(currentLine.size() > 0 && currentLine.get(currentLine.size() - 1).getType() == "Decimal")
                {
                    currentLine.add(new Multiply());
                }
                currentLine.add(new Decimal("-"));
                break;
            //operators
            case "+":
                currentLine.add(new Plus());
                break;
            case "_", "−": //underscore so hyphen can be negative number
                currentLine.add(new Minus());
                break;
            case "*", "×":
                currentLine.add(new Multiply());
                break;
            case "/", "÷":
                currentLine.add(new Divide());
                break;
            case "^":
                currentLine.add(new Exponent());
                break;
            //groupers
            case "(":
                currentLine.add(new RoundLeft());
                break;
            case ")":
                currentLine.add(new RoundRight());
                break;
            //functions
            case "sin":
                currentLine.add(new Sin());
                break;
            case "cos":
                currentLine.add(new Cos());
                break;
            case "tan":
                currentLine.add(new Tan());
                break;
            case "log":
                currentLine.add(new Log());
                break;
            case "ln":
                currentLine.add(new Ln());
                break;
            case "clr":
                if (currentLine.size() > 0)
                {
                    currentLine.clear();
                }
                else
                {
                    historyLine = 0;
                    clearScreen();
                }
                break;
            case "ent":
                //perform previous calculation in line if empty
                if (currentLine.size() == 0)
                {
                    currentLine = data.getHistory(0).get(0);
                }
                if (currentLine.size() > 0) //additonal check in case there is no history
                {
                    //get postfix
                    String value = Calculate.solveEquation(currentLine);
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
                    //create value to store in data
                    ArrayList<ArrayList<MathObject>> historyValue = new ArrayList<>();
                    historyValue.add(currentLine);
                    //TODO: add output to history once Calculate is finished
                    historyValue.add(currentLine);
                    
                    data.addHistory(historyValue);
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
            //symbols
            case "e":
                currentLine.add(new EulersNumber());
                break;
            case "pi", "PI", "Pi", "pI", "π":
                currentLine.add(new Pi());
                break;
            case "ans", "Ans", "ANs", "ANS", "aNS", "anS", "aNs":
                currentLine.add(new Ans(data));
                break;
            //functions
            case "sqrt", "√":
                currentLine.add(new Sqrt());
                break;
        }
    }
    private void updateScreen()
    {
        //fill as many slots as possible with history
        int historyIndex = 0;
        for(int i=historyLine-2; i>=0; i-=2)
        {
            screen[i] = data.getHistory(historyIndex).get(0).toString();
            screen[i+1] = data.getHistory(historyIndex).get(1).toString();
            screen[i+1] = " ".repeat(27-screen[i+1].length()) + screen[i+1];
            historyIndex++;
        }
        screen[historyLine] = currentLine.toString();
        screen[historyLine + 1] = "";
    }
}