package Menus;

import ConsoleControl.Colour;

public abstract class ErrorMenu extends Menu
{
    protected int cursorLocation = 0;
    
    private String errorName;
    private String[] options;
    private String[] message;
    
    public void onLoad(String cursorState)
    {
        cursorLocation = 0;
        updateScreen();
    }
    public void onUnload(){}
    
    /** setup methods */
    
    protected void setErrorName(String name)
    {
        errorName = name;
    }
    protected void setOptions(String[] ops)
    {
        options = ops;
    }
    protected void setMessage(String[] errorMessage)
    {
        message = errorMessage;
    }
    
    protected void moveHandeler(String direction)     
    {         
        switch (direction)         
        {
            case "w":
                if (cursorLocation > 0)
                {
                    cursorLocation--;
                }
                updateScreen();
                break;
            case "s":
                if (cursorLocation < options.length-1)
                {
                    cursorLocation++;
                }
                updateScreen();
                break;
        }
    }
    
    private void updateScreen()
    {
        screen[0] = errorName;
        //add options
        for (int i = 0; i < options.length; i++) //need index
        {
            if (i == cursorLocation)
            {
                screen[i+1] = Colour.invert((i+1) + ":") + " " + options[i]; 
            }
            else
            {
                screen[i+1] = (i+1) + ": " + options[i];
            }
        }
        
        screen[options.length+1] = "___________________________";
        
        //add message
        for (int i = 0; i<message.length; i++)
        {
            //check if out of bounds for screen
            if ((options.length + 2 + i) > 7)
            {
                break;
            }
            
            screen[options.length + 2 + i] = message[i];
        }
    }
}