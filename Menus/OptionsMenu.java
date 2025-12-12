package Menus;

import java.util.ArrayList;

import ConsoleControl.Colour;

/**
 * This class is a base for classes that have scrolling options
 */
public abstract class OptionsMenu extends Menu
{
    private ArrayList<String[]> options; //all possible options to select
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
        options = new ArrayList<>();
        String[] array;
        //loop through all inputed options
        for (int i=1; i<newOptions.length; i++)
        {
            //can have options 0-9 then A-Z
            if (i <= 9)
            {
                array = new String[] {i+": ", newOptions[i]};
                options.add(array);
            }
            //A-Z is only 1-26 with 9 offset
            else if (i <= 26+9)
            {
                array = new String[] {(char)(i-10+65) + ": ", newOptions[i]};
                options.add(array);
            }
            else
            {
                 array = new String[]{" : ", newOptions[i]};
                 options.add(array);
            }
        }
    }
    protected void resetPositions()
    {
        cursorPos = 0;
        topLine = 0;
    }
    protected String getCurrentOption()
    {
        return options.get(topLine + cursorPos)[1];
    }
    protected String getFullOption()
    {
         String[] option = options.get(topLine + (topLine - cursorPos));
         return option[0] + option[1];
    }
    protected String getOptionWithKey(String key)
    {
        //loop through options until correct key is found, then return
        for (String[] option:options)
        {
            if (option[0].equals(key + ": "))
            {
                return option[1];
            }
        }
        return "keyDoesNotExist";
    }
    protected void handleMovement(String action)
    {
        switch (action)
        {
            //move selected item up and down
            case "w":
                if (cursorPos == 0)
                {
                    cursorPos = options.size() - 1;
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
                if (cursorPos == options.size() - 1)
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
                screen[i+1] = Colour.invert(options.get(topLine+i)[0].substring(0, 2)) + options.get(topLine+i)[0].substring(2) + options.get(topLine+i)[1];
            }
            else
            {
                screen[i+1] = options.get(topLine + i)[0] + options.get(topLine+i)[1];
            }
        }
    }
}