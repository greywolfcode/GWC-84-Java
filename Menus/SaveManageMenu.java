package Menus;

import java.util.Stack;

import java.io.IOException;

import GWC_84_Java.Data;
import GWC_84_Java.FileHandling;
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
            save = new Message("" + FileHandling.getDefaultSave());
        }
        
        int saveNum = Integer.parseInt(save.getMString());
        currentSave = saveNum - 1; //0 is defualt path, so offset by 1
        
        if (saveNum == 0)
        {
            defaultPath = true;
            path = FileHandling.getDefaultPath();
            updateScreen();
            return;
        }
        defaultPath = false;
        path = FileHandling.getPath(currentSave);
        
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
                    FileHandling.setDefaultPath(event);
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
                if (cursorPos < 5)
                {
                    cursorPos++;
                }
                break;
            case "1":
                load();
                pushEvent("prevMenu");
                break;
            case "2":
                save();
                pushEvent("prevMenu");
                break;
            case "3":
                makeDefault();
                pushEvent("prevMenu");
                break;
            case "4":
                FileHandling.resetPath(currentSave);
                pushEvent("prevMenu");
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "ent":
                if (cursorPos == 1)
                {
                    load();
                }
                else if (cursorPos == 2)
                {
                    save();
                }
                else if (cursorPos == 3)
                {
                    makeDefault();
                }
                else if (cursorPos == 4)
                {
                    FileHandling.resetPath(currentSave);
                }
                pushEvent("switch MemManageMenu");
                break;
            default:
                if (cursorPos == 0)
                {
                    path = event;
                    FileHandling.setPath(event, currentSave);
                }
        }
        updateScreen();
    }
    /**The following 3 are helper methods for the main 3 actions on save files*/
    private void load()
    {
        try
        {
            FileHandling.setCurrentSave(currentSave);
            FileHandling.loadSave();
        }
        catch (IOException e)
        {
            
        }
    }
    private void save()
    {
        try
        {
            FileHandling.saveFile();
            FileHandling.setCurrentSave(currentSave);
        }
        catch (IOException e)
        {
            
        }
    }
    private void makeDefault()
    {
        FileHandling.setDefaultSave(currentSave);
    }
    
    private void updateScreen()
    {
        clearScreen(); //There will be residual items without this
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
                screen[6] = "4: Reset Path";
                screen[7] = "Done";
            }
            else if (cursorPos == 1)
            {
                screen[1] = path;
                
                screen[3] = Colour.invert("1:") + " Load";
                screen[4] = "2: Save";
                screen[5] = "3: Make Default";
                screen[6] = "4: Reset Path";
                screen[7] = "Done";
            }
            else if (cursorPos == 2)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = Colour.invert("2:") + " Save";
                screen[5] = "3: Make Default";
                screen[6] = "4: Reset Path";
                screen[7] = "Done";
            }
            else if (cursorPos == 3)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = "2: Save";
                screen[5] = Colour.invert("3:") + " Make Default";
                screen[6] = "4: Reset Path";
                screen[7] = "Done";
            }
            else if (cursorPos == 4)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = "2: Save";
                screen[5] = "3: Make Default";
                screen[6] = Colour.invert("4:") + " Reset Path";
                screen[7] = "Done";
            }
            else if (cursorPos == 5)
            {
                screen[1] = path;
                
                screen[3] = "1: Load";
                screen[4] = "2: Save";
                screen[5] = "3: Make Default";
                screen[6] = "4: Reset Path";
                screen[7] = Colour.invert("Done");
            }
        }
    }
}