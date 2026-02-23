package MathObjects;

//import GWC_84_Java stuff
import GWC_84_Java.Data;

//import MathObject stuff
import MathObjects.Functions.Abs;
import MathObjects.Functions.ArcCos;
import MathObjects.Functions.ArcSin;
import MathObjects.Functions.ArcTan;
import MathObjects.Functions.Cbrt;
import MathObjects.Functions.Cos;
import MathObjects.Functions.FrthRt;
import MathObjects.Functions.Int;
import MathObjects.Functions.Ln;
import MathObjects.Functions.Log;
import MathObjects.Functions.Sin;
import MathObjects.Functions.Sqrt;
import MathObjects.Functions.Tan;

import MathObjects.Groupers.RoundLeft;
import MathObjects.Groupers.RoundRight;

import MathObjects.Helpers.Blank;
import MathObjects.Helpers.ClearEntries;
import MathObjects.Helpers.Done;

import MathObjects.Numbers.Decimal;

import MathObjects.Operators.Divide;
import MathObjects.Operators.Exponent;
import MathObjects.Operators.Minus;
import MathObjects.Operators.Multiply;
import MathObjects.Operators.NthRt;
import MathObjects.Operators.Plus;
import MathObjects.Operators.SciNotationOperator;

import MathObjects.Symbols.Ans;
import MathObjects.Symbols.EulersNumber;
import MathObjects.Symbols.Pi;
import MathObjects.Symbols.Rand;

import MathObjects.UnaryOperators.Factorial;


/**
 * Contians helepr methods for working with MathObject classes
 */
public class MathObjectHelper 
{
    private MathObjectHelper(){}
    
    /**
     * Returns object based on given ID
     */
    public static MathObject getObject(int id, Data data)
    {
        switch (id)
        {
            //Functions
            case 1:
                return new Abs();
            case 2:
                return new ArcCos();
            case 3:
                return new ArcSin();
            case 4:
                return new ArcTan();
            case 5:
                return new Cbrt();
            case 6:
                return new Cos();
            case 7:
                return new FrthRt();
            case 8:
                return new Int();
            case 9:
                return new Ln();
            case 10:
                return new Log();
            case 11:
                return new Sin();
            case 12:
                return new Sqrt();
            case 13:
                return new Tan();
            //Groupers
            case 14:
                return new RoundLeft();
            case 15:
                return new RoundRight();
            //Helpers
            case 16:
                return new Blank();
            case 17:
                return new ClearEntries();
            case 18:
                return new Done();
            //Numbers
            case 19:
                return new Decimal();
            //Operators
            case 20:
                return new Divide();
            case 21:
                return new Exponent();
            case 22:
                return new Minus();
            case 23:
                return new Multiply();
            case 24:
                return new NthRt();
            case 25:
                return new Plus();
            case 26:
                return new SciNotationOperator();
            //Unary Operators
            case 27:
                return new Factorial();
            //Symbols
            case 28:
                return new Ans(data);
            case 29:
                return new EulersNumber();
            case 30:
                return new Pi();
            case 31:
                return new Rand();
        }
        return new Decimal(0); //default value
    }
}