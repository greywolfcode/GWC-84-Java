package Menus;

//java standard libraries
import java.util.Stack;
import java.util.ArrayList;

//GWC_84_Java stuff
import GWC_84_Java.Data;
import GWC_84_Java.Calculate;

//import MathObject classes
import MathObjects.MathObject;
//helpers:
import MathObjects.Helpers.Blank;
import MathObjects.Helpers.Done;
//numbers:
import MathObjects.Numbers.Decimal;
//operators:
import MathObjects.Operators.Minus;

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
        if (!data.checkMessageReturned())
        {
            String returnValue = data.getReturnMessage().getMString();
            switch (returnValue)
            {
                case "goto":
                    currentLine = data.getHistory(0).get(0);
                    currentLine.add(new Blank());
                    break;
                default:
                    addToCurrentLine(cursorLocation, returnValue, cursorState);
                    break;
            }
        }
        else if (!data.checkMathReturned)
        {
            currentLine.add(cursorLocation, data.getReturnMath(), cursorState);
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
                //if possible, add to current Decimal object. Only add if at the end of currentLine
                if (currentLine.size() > 1 && currentLine.get(currentLine.size() - 2) instanceof Decimal && cursorLocation == currentLine.size() - 1)
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
            //handle negative seperatly since it has to go at the start of the number
            case "-":
                if(currentLine.size() > 0 && currentLine.get(currentLine.size() - 1) instanceof Decimal)
                {
                    addToCurrentLine(cursorLocation, new Multiply(), cursorState);
                }
                addToCurrentLine(cursorLocation, new Decimal("-"), cursorState);
                break;
            case "clr":
                if (currentLine.size() > 1)
                {
                    currentLine.clear();
                    currentLine.add(new Blank()); //re-add the cursor
                    cursorLocation = 0;
                    updateCursor = false;
                }
                else
                {
                    historyLine = 0;
                    clearScreen();
                    updateCursor = false;
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
                else if (currentLine.get(0) instanceof ClearEntries) //check if need to clear entries
                {
                    //create objects for storing ClearEntries line in history
                    ArrayList<ArrayList<MathObject>> historyValue = new ArrayList<ArrayList<MathObject>>();
                    ArrayList<MathObject> input = new ArrayList<MathObject>();                     
                    input.add(currentLine.get(0));
                    ArrayList<MathObject> output = new ArrayList<MathObject>();
                    output.add(new Done());
                    historyValue.add(input);
                    historyValue.add(output);
                    
                    data.clearHistory();
                    //add to history after clearing it
                    data.addHistory(historyValue);
                    //clear line
                    currentLine.clear();
                    currentLine.add(new Blank());
                    //update screen stuff
                    historyLine = 0;
                    clearScreen();
                    updateCursor = false;
                    cursorLocation = 0;
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
                addObejctsFromString(cursorLocation, event, cursorState);
                break;
        }
    }
    private void handeler2nd(String event, String cursorState)
    {
        addObjectsFromString(cursorLocation, event, cursorState);
    }
    /**
     * Wrapper around MathObjectHelper that does additional checks
     * and handles adding to currentLine
     */
    private void addObjectsFromString(String cursorLocation, String label, String cursorState)
    {
        //check if valid using math object helper
        MathObject[] newObjects = MathObjectHelper.getObject(label, data);
        if (newObjects == null)
        {
            updateCursor = false; //don't update cursor if no action was done 
            return;
        }
        addToCurrentLine(cursorLocation, newObjects[0], cursorState);
        
        if (newObjects.length > 1)
        {
            /* add all remaining objects
             * This is for exponents and other added objects,
             * so it needs to be inserted with the first object
            */
            for (int i=1, n=newObjects.length; i<n; i++)
            {
                addToCurrentLine(cursorLocation, newObjects[i]);
            }
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
                //deal with merging decimals
                else if (value instanceof Decimal)
                {
                    int numToMerge = 1;
                    //check one to the left
                    if (index > 0)
                    {
                        if (currentLine.get(index-1) instanceof Decimal)
                        {
                            numToMerge++;
                        }
                    }
                    //check one to the right
                    if (index < currentLine.size()-1)
                    {
                        if (currentLine.get(index+1) instanceof Decimal)
                        {
                            numToMerge++;
                        }
                    }
                    if (numToMerge > 1) //initalised as one as there is always the new Decimal to be merged
                    {
                        Decimal[] nums = new Decimal[numToMerge];
                        int newIndex = index; //new index in case it needs to be shunted over one
                        //there is probably a more efficient to do this.
                        //get new decimals
                        if (index < currentLine.size()-1) //do this 1st because the first one changes the index by one
                        {
                            if (currentLine.get(index+1) instanceof Decimal)
                            {
                                nums[nums.length-1] = (Decimal)currentLine.remove(index+1); //remove un-needed decimal
                            }
                        }
                        if (index > 0)
                        {
                            if (currentLine.get(index-1) instanceof Decimal)
                            {
                                nums[0] = (Decimal)currentLine.remove(index-1); //remove un-needed Decimal
                                cursorLocation--; //this shunts everything one to the left
                                newIndex--; //index to replace is getting shunted over one to the left
                            }
                        }
                        // value can never be in position 2; only avaliable patterns are
                        // D-V, D-V-D, V-D; value has to be at begining or in middle
                        if (nums[0] == null)
                        {
                            nums[0] = (Decimal)value;
                        }
                        else if (nums[1] == null)
                        {
                            nums[1] = (Decimal)value;
                        }
                        //merge values
                        Decimal newNum = Decimal.merge(nums);
                        newNum.setSelected("a");
                        currentLine.set(newIndex, newNum);
                        updateCursor = false;
                    }
                    else
                    {
                        currentLine.get(index+1).setSelected("a");
                        currentLine.set(index, value);
                    }
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
            if (currentLine.get(index) instanceof Decimal)
            {
                if (value instanceof Decimal)
                {
                    ((Decimal)currentLine.get(index)).insert((Decimal)value);
                    updateCursor = false;
                }
                else
                {
                    Decimal[] nums = ((Decimal)currentLine.get(index)).split(true);
                    currentLine.set(index, nums[0]); //overwrite previous Decimal
                    currentLine.add(index+1, nums[1]);
                    currentLine.add(index+1, value);
                    
                    currentLine.get(index+2).setSelected("d");
                    cursorLocation++;
                }
            }
            else
            {
                if (value instanceof Decimal)
                {
                    if (index > 0 && currentLine.get(index - 1) instanceof Decimal)
                    {
                        Decimal[] nums = {(Decimal)currentLine.get(index-1), (Decimal)value};
                        Decimal mergedDecimal = Decimal.merge(nums);
                        currentLine.set(index-1, mergedDecimal);
                        updateCursor = false;
                    }
                    else
                    {
                        currentLine.add(index-1, value);
                    }
                }
                else
                {
                    currentLine.add(index-1, value); //inserts before currently selected token
                }
            }
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