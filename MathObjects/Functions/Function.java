package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Numbers.Numbers;

/**
 * Basis for all function obejcts
 */
public abstract class Function extends MathObject
{
    public abstract Numbers evaluate(Numbers value);
}