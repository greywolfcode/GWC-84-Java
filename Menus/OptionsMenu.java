package Menus;

import GWC_84_Java.Menu;
import ConsoleControl.Colour;

/**
 * This class is a base for classes that have scrolling options
 */
public abstract class OptionsMenu extends Menu
{
    private String[] options; //all possible options to select
    private String[] topBarMenus; //stores other menus in current options menu
    private String topBar = "\b"; //stores topBar String to display
    private int selectedMenu; //stores menu to select on topBar
    private int cursorPos = 0; //current selected item on screen
    private int topLine = 0; //current line at the top of the screen
    
    //To be called once at the end of constructor
    protected void setTopBar(String[] newTopBar, int currentSelectedMenu)
    {
        topBarMenus = newTopBar;
        selectedMenu = currentSelectedMenu;
        updateTopBar();
    }
    protected void updateTopBar()
    {
        for (int i=0; i<topBarMenus.length; i++)
        {
            if (i == selectedMenu)
            {
                topBar += " " + Colour.invert(topBarMenus[i]) ;  
            }
            else
            {
                topBar += " " + topBarMenus[i];
            }
        }
    }
    protected void setOptions(String[] newOptions)
    {
        options = newOptions;
    }
    protected void resetPositions()
    {
        cursorPos = 0;
        topLine = 0;
    }
    protected String getCurrentOption()
    {
        //remove number from begining of menu
        return options[topLine + (topLine - cursorPos)].substring(2);
    }
    protected String getFullOption()
    {
        return options[topLine + (topLine - cursorPos)];
    }
    protected void handleMovement(String action)
    {
        switch (action)
        {
            //move selected item up and down
            case "w":
                if (cursorPos == 0)
                {
                    cursorPos = options.length - 1;
                    topLine = cursorPos - 6;
                }
                else if (cursorPos == topLine)
                {
                    cursorPos--;
                    topLine--;
                }
                else
                {
                    cursorPos--;
                }
                break;
            case "s":
                if (cursorPos == options.length - 1)
                {
                    cursorPos = 0;
                    topLine = 0;
                }
                else if (cursorPos == topLine + 6)
                {
                    cursorPos++;
                    topLine++;
                }
                else
                {
                    cursorPos++;
                }
                break;
            //switch which options menu is selected
            case "a":
                break;
            case "d":
                break;
        }
    }
    protected void updateScreen()
    {
        screen[0] = topBar;
        for (int i=0; i<7; i++)
        {
            //Highlight number on selected line
            if (topLine + i == cursorPos)
            {
                screen[i+1] = Colour.invert(options[topLine+i].substring(0, 2)) + options[topLine+i].substring(2);
            }
            else
            {
                screen[i+1] = options[topLine + i];
            }
        }
    }
}