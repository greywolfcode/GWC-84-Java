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
        String[] options = {"1: 🞂Frac","2: 🞂Dec","3: ³", "4: ∛", "5: ᕽ√", "6: fMin(", "7: fMax(", "8: nDeriv(", "9: fnInt(", "0: sum ∑", "A: LOGBASE(", "B: piecewise(", "C: Num Solver"};
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
            case "clr":
                pushEvent("prevMenu");
                break;
            case "ent":
                break;
        }
        updateScreen();
    }
}