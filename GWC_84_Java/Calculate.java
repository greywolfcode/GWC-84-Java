package GWC_84_Java;

//import standard libraries
import java.util.Stack;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.lang.ArithmeticException;

//import MathObject stuff
import MathObjects.MathObject;

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
        ArrayList<MathObject> postfix = toPostFix(input);
        //catch error with equation
        try
        {
            return solvePostFix(postfix) + "";
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
            if (token.getType().equals("operator"))
            {
                
                if (ops.size() == 0 || ops.peek().getType().equals("Grouper"))
                {
                    ops.push(token);
                }
                else if (token.getPresedence() > ops.peek().getPresedence())
                {
                    ops.push(token);
                }
                else if (token.getPresdence() == ops.peek().getPresdence() && token.getAssociative().equals("right"))
                {
                    ops.push(token);
                }
                else
                {
                    while((token.getPresedence() < ops.peek().getPresedence()) || (token.getPresdence() == ops.peek().getPresedence() && token.getAssociative().equals("left")))
                    {
                        output.add(ops.pop());
                        if (ops.size() == 0)
                        {
                            break;
                        }
                    }
                    ops.push(token);
                }
            }
            else if (token.getType().equals("grouper") && token.getGrouperType().equals("round"))
            {
               if (token.getSide().equals("left"))
               {
                    ops.push(token); 
               }
               else
               {
                    //loop through until closing brace is found
                    while (true)
                    {
                        if (ops.peek().getType().equals("Grouper") && ops.peek().getGrouperType.equals("round") && ops.peek().getSide().equals("right"))
                        {
                            ops.pop(); //remove paren
                            break;
                        }
                        output.add(ops.pop());
                    }
                    //check if there is a function that needs to be moved
                    if (ops.peek().equals("Function"))
                    {
                        output.add(ops.pop());
                    }
               }
            }
            //handle functions
            else if (token.getType().equals("Function"))
            {
                ops.push(token);
            }
            //handle symbols
            else if(token.getType().equals("Symbol"))
            {
                output.add(token);
            }
        }
        //move all remaining operators to output
        while(ops.size() > 0)
        {
            output.add(ops.pop());
        }
        return output;
    }
    /**
     * Evalutates postfix
     */
    public static double solvePostFix(ArrayList<MathObject> input)
    {
        //create stack to store working values
        Stack<Double> values = new Stack<>();
        double num1;
        double num2;
        //loop thorugh all values
        for (String value : input)
        {
            //evaluate operators
            if (value.equals("+"))
            {
                num1 = values.pop();
                num2 = values.pop();
                values.push(num2 + num1);
            }
            else if (value.equals("−"))
            {
                num1 = values.pop();
                num2 = values.pop();
                values.push(num2 - num1); 
            }
            else if (value.equals("×"))
            {
                num1 = values.pop();
                num2 = values.pop();
                values.push(num2 * num1);
            }
            else if (value.equals("÷"))
            {
                num1 = values.pop();
                num2 = values.pop();
                //check for div/0
                if (num1 == 0)
                {
                    throw new ArithmeticException("div/0");
                }
                values.push(num2 / num1);
            }
            else if (value.equals("^"))
            {
                num1 = values.pop();
                num2 = values.pop();
                values.push(Math.pow(num2, num1));
            }
            //evaluate functions
            else if(value.equals("sin"))
            {
                num1 = values.pop();
                values.push(Math.sin(num1));
            }
            else if (value.equals("cos"))
            {
                num1 = values.pop();
                values.push(Math.cos(num1));
            }
            else if (value.equals("tan"))
            {
                num1 = values.pop();
                values.push(Math.tan(num1));
            }
            else if (value.equals("log"))
            {
                num1 = values.pop();
                values.push(Math.log10(num1));
            }
            else if (value.equals("ln"))
            {
                num1 = values.pop();
                values.push(Math.log(num1));
            }
            else if (value.equals("√"))
            {
                num1 = values.pop();
                values.push(Math.sqrt(num1));
            }
            //replace special numbers with actual values
            else if (value.equals("π"))
            {
                values.push(Math.PI);
            }
            else if (value.equals("e"))
            {
                values.push(Math.E);
            }
            //just add number to output
            else
            {
                values.push(Double.parseDouble(value));
            }
        }
        //should be one value left
        return values.pop();
    }
}