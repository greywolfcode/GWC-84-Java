package GWC_84_Java;

//import standard libraries
import java.util.Stack;
import java.util.ArrayList;
import java.lang.ArithmeticException;

//import MathObject stuff
import MathObjects.MathObject;
//base classes:
import MathObjects.Operators.Operator;
import MathObjects.Functions.Function;
import MathObjects.Groupers.Grouper;
import MathObjects.Numbers.Numbers;
import MathObjects.Symbols.Symbol;
//main classes
import MathObjects.Groupers.RoundLeft;
import MathObjects.Numbers.Decimal;

/**
 * Store methods to handle performing calculations
 */
public class Calculate 
{
    private Calculate(){}
    /**
     * Converts infix to postfix, than evalutes and returns the answer
     * 
     * Returns string so that errors can be returned
     */
    public static String solveEquation(ArrayList<MathObject> input)
    {
        //catch error with equation
        try
        {
            ArrayList<MathObject> postfix = toPostFix(input);
            //return string value so that errors can be returned
            return solvePostFix(postfix).toString();
        }
        catch (ArithmeticException e)
        {
            return "div/0";
        }
        catch(Exception e)
        {
            //System.out.println(e);
            return "error";
        }
    }
    /**
     * creates postfix with Shunting Yard algorithm
     */
    public static ArrayList<MathObject> toPostFix(ArrayList<MathObject> input)
    {
        //create output ArrayList
        ArrayList<MathObject> output = new ArrayList<>();
        //loop through all tokens
        int index = 0; //using seperate index to help with ()
        Stack<MathObject> ops = new Stack<>();
        for (MathObject token:input)
        {
            //handle operators
            if (token instanceof Operator)
            {
                //create new variable of correct type
                Operator opToken = (Operator)token;
                
                if (ops.size() == 0 || ops.peek() instanceof Grouper)
                {
                    ops.push(opToken);
                }
                else if (opToken.getPresedence() > ((Operator)ops.peek()).getPresedence())
                {
                    ops.push(opToken);
                }
                else if (opToken.getPresedence() == ((Operator)ops.peek()).getPresedence() && opToken.getAssociative().equals("right"))
                {
                    ops.push(opToken);
                }
                else
                {
                    while((opToken.getPresedence() < ((Operator)ops.peek()).getPresedence()) || (opToken.getPresedence() == ((Operator)ops.peek()).getPresedence() && opToken.getAssociative().equals("left")))
                    {
                        output.add(ops.pop());
                        if (ops.size() == 0)
                        {
                            break;
                        }
                    }
                    ops.push(opToken);
                }
            }
            else if (token instanceof Grouper && ((Grouper)token).getGrouperType().equals("round"))
            {
               Grouper groupToken = (Grouper)token;
               
               if (groupToken.getSide().equals("left"))
               {
                    ops.push(token); 
               }
               else
               {
                    //loop through until closing brace is found
                    while (true)
                    {
                        if (ops.peek() instanceof Grouper && ((Grouper)ops.peek()).getGrouperType().equals("round") && ((Grouper)ops.peek()).getSide().equals("left"))
                        {
                            ops.pop(); //remove paren
                            break;
                        }
                        output.add(ops.pop());
                    }
                    //check if there is a function that needs to be moved
                    if (ops.size() > 0 && ops.peek() instanceof Function)
                    {
                        output.add(ops.pop());
                    }
               }
            }
            //handle functions
            else if (token instanceof Function)
            {
                ops.push(new RoundLeft());
                ops.push(token);
            }
            //handle symbols
            else if(token instanceof Symbol)
            {
                output.add(new Decimal(((Symbol)token).getValue()));
            }
            //handle basic numbers
            else
            {
                output.add(token);
            }
        }
        //move all remaining operators to output
        while(ops.size() > 0)
        {
            if (ops.peek() instanceof Grouper)
            {
                ops.pop();
            }
            else
            {
                output.add(ops.pop());
            }
        }
        return output;
    }
    /**
     * Evalutates postfix
     */
    public static Numbers solvePostFix(ArrayList<MathObject> input)
    {
        //create stack to store working values
        Stack<Numbers> values = new Stack<>();
        //variables to store data while working with it
        Numbers num1;
        Numbers num2;
        Numbers result;
        //loop thorugh all values
        for (MathObject value : input)
        {
            //evaluate operators
            if (value instanceof Operator)
            {
                num1 = values.pop();
                num2 = values.pop();
                result = ((Operator)value).evaluate(num1, num2);
            }
            //evaluate functions
            else if (value instanceof Function)
            {
                num1 = values.pop();
                result = ((Function)value).evaluate(num1);
            }
            //replace special numbers with actual values
            else if (value instanceof Symbol)
            {
                result = new Decimal(((Symbol)value).getValue());
            }
            //must be a number 
            else
            {
                result = ((Numbers)value);
            }
            values.push(result);
        }
        //should be one value left
        return values.pop();
    }
}