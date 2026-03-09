package Menus;

import java.util.Stack;
import GWC_84_Java.Data;

public class MemManageMenu extends OptionsMenu
{
    public MemManageMenu(Data storage, Stack<String> events)
    {
        setMenuType("return"); //might not actually have any returns
        data = storage;
        setGlobalEvents(events);
        String[] options = {"Edit Save Paths", "Choose Default Save"};         
        setOptions(options);         
        String[] topBar = {"Manage Memory"};         
        setTopBar(topBar, 0);         
        String[] classSwitchOptions = {"MemManageMenu"};         
        setClassSwitchOptions(classSwitchOptions);
    }
    public void onLoad(String cursorState)
    {
        resetPositions();
        updateScreen();
    }
    public void onUnload(){}
    
    public void eventHandeler(String state, String event, String cursorState)     
    {         
        if (state.equals("main"))         
        {             
            handelerMain(event);         
            
        }         
        updateScreen();     
    }     
    private void handelerMain(String event)     
    {         
        switch(event)         
        {             
            case "w", "s", "a", "d":                 
                handleMovement(event);                 
                break;             
            case "1", "2":                 
                pushMenuChange(getOptionWithKey(event));                 
                break;             
            case "clr":                 
                pushEvent("prevMenu");                
                break;             
            case "ent":                 
                pushMenuChange(getCurrentOption());                 
                break;         
        }     
    }     
    private void pushMenuChange(String optionName)     
    {         
        switch (optionName)         
        {             
            case "Edit Save Paths":                 
                pushEvent("switch EditPathsMenu");                 
                break;
            case "Choose Default Save":
                pushEvent("switch SetDefaultSaveMenu");
                break;
        }
    }
}