package MathObjects.Functions;

import MathObjects.MathObject;

/**
 * Basis for all function obejcts
 */
public abstract class Function extends MathObject
{
    public abstract MathObject evaluate(MathObject value);
}