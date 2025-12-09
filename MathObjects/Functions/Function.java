package MathObjects.Functions;

import MathObjects.MathObject;
import MathObjects.Numbers.Decimal;

/**
 * Basis for all function obejcts
 */
public abstract class Function extends MathObject
{
    public abstract Decimal evaluate(Decimal value);
}