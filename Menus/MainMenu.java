package Menus;

import java.util.Stack;
import java.util.ArrayList;

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
import MathObjects.Operators.NthRt;
//unary operators
import MathObjects.UnaryOperators.Factorial;
//functions
import MathObjects.Functions.Sin;
import MathObjects.Functions.Cos;
import MathObjects.Functions.Tan;
import MathObjects.Functions.ArcSin;
import MathObjects.Functions.ArcCos;
import MathObjects.Functions.ArcTan;
import MathObjects.Functions.Log;
import MathObjects.Functions.Ln;
import MathObjects.Functions.Sqrt;
import MathObjects.Functions.Cbrt;
import MathObjects.Functions.FrthRt;
import MathObjects.Functions.Abs;
import MathObjects.Functions.Int;
//groupers:
import MathObjects.Groupers.RoundLeft;
import MathObjects.Groupers.RoundRight;
//symbols:
import MathObjects.Symbols.Pi;
import MathObjects.Symbols.EulersNumber;
import MathObjects.Symbols.Ans;
import MathObjects.Symbols.Rand;

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
                break;
            case "∛":
                currentLine.add(new Cbrt());
                break;
            case "∜":
                currentLine.add(new FrthRt());
                break;
            case "³":
                currentLine.add(new Exponent());
                currentLine.add(new Decimal(3));
                break;
            case "ᕽ√":
                currentLine.add(new NthRt());
                break;
            case "rand":
                currentLine.add(new Rand());
                break;
            case "abs(":
                currentLine.add(new Abs());
                break;
            case "!":
                currentLine.add(new Factorial());
                break;
            case "int(":
                currentLine.add(new Int());
                break;
        }
        updateScreen();
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
                if (currentLine.size() > 0 && currentLine.get(currentLine.size() - 1) instanceof Decimal)
                {
                    //cast to decimal so add method can be run
                    ((Decimal)currentLine.get(currentLine.size() - 1)).add(event);
                }
                //creat new object when required
                else
                {
                     currentLine.add(new Decimal(event));
                }
                break;
            //handle negative seperatly since it has to go at the start of the numbe-
            case "-":
                if(currentLine.size() > 0 && currentLine.get(currentLine.size() - 1) instanceof Decimal)
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
            case "^2", "²":
                currentLine.add(new Exponent());
                currentLine.add(new Decimal(2));
                break;
            case "^-1", "⁻¹":
                currentLine.add(new Exponent());
                currentLine.add(new Decimal("-1"));
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
                //perform previous calculation in line if empty or break if no hostory
                if (currentLine.size() == 0 && data.getHistorySize() > 0)
                {
                    currentLine = new ArrayList<MathObject>(data.getHistory(0).get(0)); //copy the ArrayList so clearing currentLine doesn't clear the one storred in history
                }
                else if (currentLine.size() == 0) //get out clause if there is nothing in the current line
                {
                    break;
                }
                //get postfix
                String value = Calculate.solveEquation(currentLine);
                //check for error
                if (value.equals("error"))
                {
                    value = "Error";
                    pushEvent("switch SyntaxError"); //add command to switch the menu
                }
                else if (value.equals("div/0"))
                {
                    value = "DIV/0";
                    pushEvent("switch DivideByZeroError");
                }
                else if (value.equals("domainError"))
                {
                    value = "Domain Error";
                    pushEvent("switch DomainError");
                }
                else if (value.equals("nonRealError"))
                {
                    value = "Non Real Number";
                    pushEvent("switch NonRealError");
                }
                //create value to store in data
                ArrayList<ArrayList<MathObject>> historyValue = new ArrayList<>();
                
                //shallow copy currentLine; don't need to copy stored objects, 
                //as the original will be cleared anyway
                ArrayList<MathObject> inputLine = new ArrayList<MathObject>(currentLine);
                historyValue.add(inputLine);
                //convert output to the right format and add it
                ArrayList<MathObject>output = new ArrayList<>();
                output.add(new Decimal(value));
                
                historyValue.add(output);
                
                data.addHistory(historyValue);
                currentLine.clear(); 
                if (historyLine < 6)
                {
                    historyLine+=2;
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
            case "e^", "e^x", "eᕽ":
                currentLine.add(new EulersNumber());
                currentLine.add(new Exponent());
                break;
            case "10^", "10^x", "10ᕽ":
                currentLine.add(new Decimal(10));
                currentLine.add(new Exponent());
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
            case "asin", "sin^-1", "sin⁻¹":
                currentLine.add(new ArcSin());
                break;
            case "acos", "cos^-1", "cos⁻¹":
                currentLine.add(new ArcCos());
                break;
            case "atan", "tan^-1", "tan⁻¹":
                currentLine.add(new ArcTan());
                break;
        }
    }
    private void updateScreen()
    {
        //fill as many slots as possible with history
        int historyIndex = 0;
        for(int i=historyLine-2; i>=0; i-=2)
        {
            screen[i] = data.getHistory(historyIndex).get(0).toString().replace("[", "").replace("]", "").replace(", ", "");
            screen[i+1] = data.getHistory(historyIndex).get(1).toString();
            screen[i+1] = " ".repeat(27-screen[i+1].length()) + screen[i+1].replace("[", "").replace("]", "").replace(", ", "");
            historyIndex++;
        }
        screen[historyLine] = currentLine.toString().replace("[", "").replace("]", "").replace(", ", "");
        screen[historyLine + 1] = "";
    }
}