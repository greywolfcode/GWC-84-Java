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
import MathObjects.Symbols.Nan;

import MathObjects.UnaryOperators.Factorial;


/**
 * Contians helepr methods for working with MathObject classes
 * and retrieving them
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
            case 33:
                return new Nan();
            default:
                return new Decimal(0); //default value
        }
    }
    /**
     * Get MathObject based on input String
     * 
     * return a MathObject Array as some inputs (e.g. ^2)
     * return multiple objects
     */
    public static MathObject[] getObject(String name, Data data)
    {
        switch(name)
        {
            //Functions             
            case "abs(":                 
                return new MathObject[] {new Abs()};                 
            case "asin", "sin^-1", "sin⁻¹":                
                return new MathObject[] {new ArcSin()};                 
            case "acos", "cos^-1", "cos⁻¹":                
                return new MathObject[] {new ArcCos()};                 
            case "atan", "tan^-1", "tan⁻¹":                
                return new MathObject[] {new ArcTan()};                 
            case "∛":                 
                return new MathObject[] {new Cbrt()};                
            case "cos":                 
                return new MathObject[] {new Cos()};
            case "∜":                 
                return new MathObject[] {new FrthRt()};                 
            case "int(":                 
                return new MathObject[] {new Int()};
            case "ln":                 
                return new MathObject[] {new Ln()};                 
            case "log":                 
                return new MathObject[] {new Log()};
            case "sin":                 
                return new MathObject[] {new Sin()};                 
            case "sqrt", "√":                 
                return new MathObject[] {new Sqrt()};                 
            case "tan":                 
                return new MathObject[] {new Tan()};   
            //Groupers             
            case "(":                 
                return new MathObject[] {new RoundLeft()};                 
            case ")":                 
                return new MathObject[] {new RoundRight()};
            //Helpers
            case "ClearEntries":                 
                return new MathObject[] {new ClearEntries()};
            //Numbers
            case "10^", "10^x", "10ᕽ":                
                return new MathObject[] {new Decimal(10), new Exponent()};                 
            //Operators             
            case "/", "÷":                 
                return new MathObject[] {new Divide()};                 
            case "^":                 
                return new MathObject[] {new Exponent()};                 
            case "^-1", "⁻¹":                
                return new MathObject[] {new Exponent(), new Decimal("-1")};
            case "^2", "²":                 
                return new MathObject[] {new Exponent(), new Decimal(2)};                 
            case "^3", "³":                 
                return new MathObject[] {new Exponent(), new Decimal(3)};                 
            case "_", "−": //underscore so hyphen can be negative number                 
                return new MathObject[] {new Minus()};            
            case "*", "×":                 
                return new MathObject[] {new Multiply()};                 
            case "ᕽ√":                 
                return new MathObject[] {new NthRt()};                 
            case "+":                 
                return new MathObject[] {new Plus()};                 
            case "ᴇ", "ᴇᴇ", "E", "EE":                 
                return new MathObject[] {new SciNotationOperator()};     
            //Unary Operators
            case "!":                 
                return new MathObject[] {new Factorial()};                
            //symbols             
            case "ans", "Ans", "ANs", "ANS", "aNS", "anS", "aNs":                 
                return new MathObject[] {new Ans(data)};  
            case "e":                 
                return new MathObject[] {new EulersNumber()};                 
            case "e^", "e^x", "eᕽ":                 
                return new MathObject[] {new EulersNumber(), new Exponent()};                 
            case "pi", "PI", "Pi", "pI", "π":                 
                return new MathObject[] {new Pi()};                 
            case "rand":                 
                return new MathObject[] {new Rand()};
            default:
                return null; //show no value could be found
        }
    }
}