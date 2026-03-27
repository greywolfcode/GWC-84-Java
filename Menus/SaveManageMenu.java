package Menus;

import java.util.Stack;

import GWC_84_Java.Data;
import GWC_84_Java.Message;
import GWC_84_Java.Exceptions.NoReturnException;

import ConsoleControl.Colour;

public class SaveManageMenu extends Menu
{
    //path/save data
    private boolean defaultPath = false;
    private int currentSave = 0;
    private String path;
    
    //ui data
    private int cursorPos = 0;
    
    public SaveManageMenu(Data storage, Stack<String> events)
    {
        data = storage;
        setMenuType("action");
        setGlobalEvents(events);
    }
    public void onLoad(String cursor)
    {
        cursorPos = 0;
        //get current save from data
        Message save;
        try
        {
           save = data.getReturnMessage();
        }
        catch(NoReturnException e)
        {
            save = new Message("" + data.getDefaultSave());
        }
        
        int saveNum = Integer.parseInt(save.getMString());
        currentSave = saveNum;
        
        if (saveNum == 0)
        {
            defaultPath = true;
            path = data.getDefaultPath();
            return;
        }
        defaultPath = false;
        path = data.getPath(saveNum);
        
        updateScreen();
    }
    public void onUnload(){}
    
    public void eventHandeler(String state, String event, String cursor)
    {
        if (defaultPath)
        {
            eventHandelerDefaultPath(event);
        }
        else
        {
            eventHandelerSave(event);
        }
    }
    
    private void eventHandelerDefaultPath(String event)
    {
        switch(event)
        {
            case "w":
                cursorPos = 0;
                break;
            case "s":
                cursorPos = 1;
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "ent":
                if (cursorPos == 1)
                {
                    pushEvent("switch MemManageMenu");
                }
                break;
            default:
                if (cursorPos == 0)
                {
                    path = event;
                    data.setDefaultPath(event);
                }
                break;
        }
        updateScreen();
    }
    private void eventHandelerSave(String event)
    {
        switch (event)
        {
            case "w":
                if (cursorPos > 0)
                {
                    cursorPos--;
                }
                break;
            case "s":
                if (cursorPos < 4)
                {
                    cursorPos++;
                }
                break;
            case "1":
                pushEvent("prevMenu");
                break;
            case "2":
                pushEvent("prevMenu");
                break;
            case "3":
                pushEvent("prevMenu");
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "ent":
                if (cursorPos == 4)
                {
                    pushEvent("switch MemManageMenu");
                }
                break;
            default:
                if (cursorPos == 0)
                {
                    path = event;
                    data.setPath(event, currentSave);
                }
        }
    }
    
    private void updateScreen()
    {
        if (defaultPath)
        {
            screen[0] = "Default Path:";
            if (cursorPos == 0)
            {
                screen[1] = Colour.invert(path);
                screen[2] = "Done";
            }
            else
            {
                screen[1] = path;
                screen[2] = Colour.invert("Done");
            }
        }
        else
        {
            screen[0] = "path:";
            
            if (cursorPos == 0)
            {
                screen[1] = Colour.invert(path);
                
                screen[3] = "1: Load";
                screen[4] = "2: Save";
                screen[5] = "3: Make Default";
                
                screen[7] = "Done";
            }
            else if (cursorPos == 1)
            {
                screen[1] = path;
                
                screen[3] = Colour.invert("1:") + " Load";
                screen[4] = "2: Save";
                screen[5] = "3: Make Default";
                
                screen[7] = "Done";
            }
            else if (cursorPos == 2)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = Colour.invert("2:") + " Save";
                screen[5] = "3: Make Default";
                screen[7] = "Done";
            }
            else if (cursorPos == 3)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = "2: Save";
                screen[5] = Colour.invert("3: Make Default");
                
                screen[7] = "Done";
            }
            else if (cursorPos == 4)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = "2: Save";
                screen[5] = "3: Make Default";
                
                screen[7] = Colour.invert("Done");
            }
        }
    }
}