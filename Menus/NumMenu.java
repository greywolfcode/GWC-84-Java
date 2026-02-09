package Menus;

import java.util.Stack;
import GWC_84_Java.Data;
import ConsoleControl.Colour;

public class NumMenu extends OptionsMenu
{
    public NumMenu(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        String[] options = {"abs(", "round(", "iPart(", "fPart(", "int(", "min(", "max(", "lcm(", "gcd(", "remainder(", "🞂n⁄d🞀🞂Un⁄d", "🞂F🞀🞂D", "Un⁄d", "n⁄d"};
        setOptions(options);
        String[] topBar = {"MATH", "NUM", "CMPLX", "PROB", "FRAC"};
        setTopBar(topBar, 1);
        String[] classSwitchOptions = {"MathMenu", "NumMenu", "CmplxMenu", "ProbMenu", "FracMenu"};
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
        else if (state.equals("2nd"))
        {
            handeler2nd(event);
        }
        else if (state.equals("alp"))
        {
            handelerAlpha(event);
        }
        updateScreen();
    }
    private void handelerMain(String event)
    {
        switch (event)
        {
            case "w", "s", "a", "d":
                handleMovement(event);
                break;
            case "1", "2", "3", "4", "5", "6", "7", "8", "9":
                String value = getOptionWithKey(event);
                //check if value was defaulted
                if (value.equals("keyDoesNotExist"))
                {
                    break;
                }
                data.setReturn(value);
                pushEvent("prevMenu");
                break;
            case "clr":
                pushEvent("prevMenu");
                break;
            case "ent":
                data.setReturn(getCurrentOption());
                pushEvent("prevMenu");
                break;
        }
    }
    private void handeler2nd(String event)
    {
        switch (event)
        {
            case "quit":
                pushEvent("prevMenu");
        }
    }
    private void handelerAlpha(String event)
    {
        switch (event)
        {
            case "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z":
                String value = getOptionWithKey(event);
                if (value.equals("keyDoesNotExist"))
                {
                    break;
                }
                data.setReturn(value);
                pushEvent("prevMenu");
                break;
        }
    }
}