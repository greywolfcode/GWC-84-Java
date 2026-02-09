package Menus;

import java.util.Stack;
import java.util.ArrayList;

import GWC_84_Java.Data;
import GWC_84_Java.Calculate;

//import MathObject classes
import MathObjects.MathObject;
import MathObjects.Blank;
//numbers:
import MathObjects.Numbers.Decimal;
//operators:
import MathObjects.Operators.Plus;
import MathObjects.Operators.Minus;
import MathObjects.Operators.Multiply;
import MathObjects.Operators.Divide;
import MathObjects.Operators.Exponent;
import MathObjects.Operators.NthRt;
import MathObjects.Operators.SciNotationOperator;
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
    private int historyLine = 0; //stores how many lines of history there are
    private boolean updateCursor = true;
    
    
    public MainMenu(Data storage, Stack<String> events)
    {
        setMenuType("action");
        data = storage;
        setGlobalEvents(events);
        currentLine.add(new Blank()); //add blank token for cursor
    }
    public void onLoad(String cursorState)
    {
        String returnValue = data.getReturn();
        switch (returnValue)
        {
            case "goto":
                currentLine = data.getHistory(0).get(0);
                currentLine.add(new Blank());
                break;
            case "∛":
                addToCurrentLine(cursorLocation, new Cbrt(), cursorState);
                break;
            case "∜":
                addToCurrentLine(cursorLocation, new FrthRt(), cursorState);
                break;
            case "³":
                addToCurrentLine(cursorLocation, new Exponent(), cursorState);
                addToCurrentLine(cursorLocation, new Decimal(3));
                break;
            case "ᕽ√":
                addToCurrentLine(cursorLocation, new NthRt(), cursorState);
                break;
            case "rand":
                addToCurrentLine(cursorLocation, new Rand(), cursorState);
                break;
            case "abs(":
                addToCurrentLine(cursorLocation, new Abs(), cursorState);
                break;
            case "!":
                addToCurrentLine(cursorLocation, new Factorial(), cursorState);
                break;
            case "int(":
                addToCurrentLine(cursorLocation, new Int(), cursorState);
                break;
            default:
                updateCursor = false;
                break;
        }
        if (updateCursor)
        {
            cursorLocation++;
        }
        updateCursor = true;
        
        updateScreen();
    }
    public void onUnload(){}
    public void eventHandeler(String state, String event, String cursorState)
    {
        if (state.equals("main"))
        {
            handelerMain(event, cursorState);
        }
        else if (state.equals("2nd"))
        {
            handeler2nd(event, cursorState);
        }
        //check if need to move cursor
        if (updateCursor)
        {
            cursorLocation += 1;
        }
        updateCursor = true;
        //update screen
        updateScreen();
    }
    private void handelerMain(String event, String cursorState)
    {
        switch (event)
        {
            //values that can be in a decimal
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".":
                //if possible, add to current Decimal object
                if (currentLine.size() > 1 && currentLine.get(currentLine.size() - 2) instanceof Decimal)
                {
                    updateCursor = false; //not changing length of currentLine
                    //cast to decimal so add method can be run
                    ((Decimal)currentLine.get(currentLine.size() - 2)).add(event);
                }
                //creat new object when required
                else
                {
                     addToCurrentLine(cursorLocation, new Decimal(event), cursorState);
                }
                break;
            //handle negative seperatly since it has to go at the start of the numbe-
            case "-":
                if(currentLine.size() > 0 && currentLine.get(currentLine.size() - 1) instanceof Decimal)
                {
                    addToCurrentLine(cursorLocation, new Multiply(), cursorState);
                }
                addToCurrentLine(cursorLocation, new Decimal("-"), cursorState);
                break;
            //operators
            case "+":
                addToCurrentLine(cursorLocation, new Plus(), cursorState);
                break;
            case "_", "−": //underscore so hyphen can be negative number
                addToCurrentLine(cursorLocation, new Minus(), cursorState);
                break;
            case "*", "×":
                addToCurrentLine(cursorLocation, new Multiply(), cursorState);
                break;
            case "/", "÷":
                addToCurrentLine(cursorLocation, new Divide(), cursorState);
                break;
            case "^":
                addToCurrentLine(cursorLocation, new Exponent(), cursorState);
                break;
            case "^2", "²":
                addToCurrentLine(cursorLocation, new Exponent(), cursorState);
                addToCurrentLine(cursorLocation, new Decimal(2));
                break;
            case "^-1", "⁻¹":
                addToCurrentLine(cursorLocation, new Exponent(), cursorState);
                addToCurrentLine(cursorLocation, new Decimal("-1"));
                break;
            //groupers
            case "(":
                addToCurrentLine(cursorLocation, new RoundLeft(), cursorState);
                break;
            case ")":
                addToCurrentLine(cursorLocation, new RoundRight(), cursorState);
                break;
            //functions
            case "sin":
                addToCurrentLine(cursorLocation, new Sin(), cursorState);
                break;
            case "cos":
                addToCurrentLine(cursorLocation, new Cos(), cursorState);
                break;
            case "tan":
                addToCurrentLine(cursorLocation, new Tan(), cursorState);
                break;
            case "log":
                addToCurrentLine(cursorLocation, new Log(), cursorState);
                break;
            case "ln":
                addToCurrentLine(cursorLocation, new Ln(), cursorState);
                break;
            case "clr":
                if (currentLine.size() > 0)
                {
                    currentLine.clear();
                    currentLine.add(new Blank()); //re-add the cursor
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
                    currentLine = new ArrayList<MathObject>(data.getHistory(0).get(0)); //copy the ArrayList so clearing currentLine doesn't clear the one stored in history
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
                inputLine.removeIf(element -> element instanceof Blank); //remove blank 
                //make sure nothing is selected
                if (cursorLocation < inputLine.size())
                {
                    inputLine.get(cursorLocation).setUnselected();
                }
                historyValue.add(inputLine);
                //convert output to the right format and add it
                ArrayList<MathObject>output = new ArrayList<>();
                output.add(new Decimal(value));
                
                historyValue.add(output);
                
                data.addHistory(historyValue);
                currentLine.clear(); 
                currentLine.add(new Blank()); //add blank cursor token 
                //reset cursor
                cursorLocation = 0;
                updateCursor = false;
                if (historyLine < 6)
                {
                    historyLine+=2;
                }
                break;
            case "w":
                break;
            case "a":
                updateCursor = false;
                //check if need to change selected token
                if (currentLine.get(cursorLocation).setSelected("a"))
                {
                    if (cursorLocation == 0) //keep selection on last token
                    {
                        currentLine.get(cursorLocation).setSelected("d"); //flip direction for first charachter of decimal
                        break;
                    }
                    cursorLocation--;
                    currentLine.get(cursorLocation).setSelected("a");
                }
                break;
            case "s":
                break;
            case "d":
                updateCursor = false;
                //check if need to change selected token
                if (currentLine.get(cursorLocation).setSelected("d"))
                {
                    if (cursorLocation == currentLine.size()-1)
                    {
                        currentLine.get(cursorLocation).setSelected("a"); //flip direction for last charachter of decimal
                        break;
                    }
                    cursorLocation++;
                    currentLine.get(cursorLocation).setSelected("d");
                }
                break;
            default:
                updateCursor = false; //don't update cursor if no action was done 
                break;
        }
    }
    private void handeler2nd(String event, String cursorState)
    {
        switch (event)
        {
            //symbols
            case "e":
                addToCurrentLine(cursorLocation, new EulersNumber(), cursorState);
                break;
            case "e^", "e^x", "eᕽ":
                addToCurrentLine(cursorLocation, new EulersNumber(), cursorState);
                addToCurrentLine(cursorLocation, new Exponent());
                break;
            case "10^", "10^x", "10ᕽ":
                addToCurrentLine(cursorLocation, new Decimal(10), cursorState);
                addToCurrentLine(cursorLocation, new Exponent());
                break;
            case "pi", "PI", "Pi", "pI", "π":
                addToCurrentLine(cursorLocation, new Pi(), cursorState);
                break;
            case "ans", "Ans", "ANs", "ANS", "aNS", "anS", "aNs":
                addToCurrentLine(cursorLocation, new Ans(data), cursorState);
                break;
            //functions
            case "sqrt", "√":
                addToCurrentLine(cursorLocation, new Sqrt(), cursorState);
                break;
            case "asin", "sin^-1", "sin⁻¹":
                addToCurrentLine(cursorLocation, new ArcSin(), cursorState);
                break;
            case "acos", "cos^-1", "cos⁻¹":
                addToCurrentLine(cursorLocation, new ArcCos(), cursorState);
                break;
            case "atan", "tan^-1", "tan⁻¹":
                addToCurrentLine(cursorLocation, new ArcTan(), cursorState);
                break;
            case "ᴇ", "ᴇᴇ", "E", "EE":
                addToCurrentLine(cursorLocation, new SciNotationOperator(), cursorState);
                break;
            default:
                updateCursor = false;
                break;
        }
    }
    /**
     * Adds to current line by pushing all values after index to the right
     */
    private void addToCurrentLine(int index, MathObject value)
    {
        cursorLocation++; //need to move cursor location on place further than normal
        currentLine.add(index+1, value);
    }
    /**
     * Adds to current line while taking cursor location and state into account
     */
    private void addToCurrentLine(int index, MathObject value, String cursorState)
    {
        if (cursorState.equals("N"))
        {
            if (index == currentLine.size()-1)
            {
                currentLine.add(index, value); //don't overwrite Blank cursor
            }
            else
            {
                //check if currently selected value is a decimal
                if (currentLine.get(index) instanceof Decimal)
                {
                    Decimal[] nums = ((Decimal)currentLine.get(index)).split(false);
                    currentLine.set(index, nums[0]); //replace original decimal
                    if (nums.length == 2)
                    {
                        currentLine.add(index+1, nums[1]); //insert second part of decimal after first part
                    }
                    currentLine.add(index+1, value);
                    
                    currentLine.get(index+2).setSelected("d");
                    cursorLocation++;
                }
                else
                {
                    //next charachter is now selected; cursor stays in the same spot
                    currentLine.get(index+1).setSelected("a"); //manually set next token to be selected
                    currentLine.set(index, value); //replace value 
                }
            }
        }
        else
        {
            currentLine.add(index-1, value); //inserts before currently selected token
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
        screen[historyLine] = currentLine.toString().substring(1).replace("]", "").replace(", ", "");
        
        screen[historyLine + 1] = "";
    }
}