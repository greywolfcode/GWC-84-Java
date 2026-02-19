package Menus;

import java.util.Stack;
import GWC_84_Java.Data;

public class MemMenu extends OptionsMenu
{
    public MemMenu(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        String[] options = {"About", "Manage", "ClearEntries", "ClrLists", "Archive", "UnArchive", "Reset", "Group"};
        setOptions(options);
        String[] topBar = {"Memory"};
        setTopBar(topBar, 0);
        String[] classSwitchOptions = {"MemMenu"};
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
            case "1", "2", "3", "4", "5", "6", "7", "8":
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
            case "About":
                pushEvent("switch AboutMenu");
                break;
            case "ClearEntries":
                data.setReturn(optionName);
                pushEvent("switch PrevMenu");
                break;
        }
    }
}