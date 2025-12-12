package Menus;

import java.util.Stack;
import GWC_84_Java.Data;
import ConsoleControl.Colour;

public class MathMenu extends OptionsMenu
{
    public MathMenu(Data storage, Stack<String> events)
    {
        setMenuType("return");
        data = storage;
        setGlobalEvents(events);
        String[] options = {"🞂Frac","🞂Dec","³", "∛", "∜", "ᕽ√", "fMin(", "fMax(", "nDeriv(", "fnInt(", "sum ∑", "LOGBASE(", "piecewise(", "Num Solver"};
        setOptions(options);
        String[] topBar = {"MATH", "NUM", "CMPLX", "PROB", "FRAC"};
        setTopBar(topBar, 0);
    }
    public void onLoad()
    {
        resetPositions();
        updateScreen();
    }
    public void onUnload(){}
    public void eventHandeler(String state, String event)
    {
        switch (event)
        {
            case "w", "s", "a", "d":
                handleMovement(event);
                break;
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z":
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
        updateScreen();
    }
}