//import standard libraries
import java.util.Stack;
import java.util.ArrayList;
import java.util.Map;
import java.lang.StringBuilder;
import java.lang.ArithmeticException;

/**
 * Store methods to handle performing calculations
 */
public class Calculate 
{
    //static map to hold operator presedence values
    private static Map<String, Integer> presedence =  Map.of(
        "+", 2,
        "−", 2,
        "×", 3,
        "÷", 3,
        "^", 4
        );
    
    private Calculate(){}
    /**
     * Converts infix to postfix, than evalutes and returns the answer
     */
    public static String solveEquation(String input)
    {
        ArrayList<String> postfix = toPostFix(input);
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
            return "error";
        }
    }
    /**
     * creates postfix with Shunting Yard algorithm
     */
    public static ArrayList<String> toPostFix(String input)
    {
        //create output ArrayList
        ArrayList<String> output = new ArrayList<>();
        //split string at operator charchters
        String[] tokens = input.split("​");
        
        //loop through all tokens
        int index = 0; //using seperate index to help with ()
        Stack<String> ops = new Stack<>();
        String currentToken = "";
        StringBuilder currentNumber = new StringBuilder();
        for (String token:tokens)
        {
            //Left assocaitve operators
            if (token.equals("+") || token.equals("−") || token.equals("×") || token.equals("÷"))
            {
                if (ops.size() == 0 || ops.peek().equals("("))
                {
                    ops.push(token);
                }
                else if (presedence.get(token) > presedence.get(ops.peek()))
                {
                    ops.push(token);
                }
                else
                {
                    while(presedence.get(token) <= presedence.get(ops.peek()))
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
            //right associative operators
            else if (token.equals("^"))
            {
                ops.push(token);
            }
            else if (token.equals("("))
            {
               ops.push(token); 
            }
            else if (token.equals(")"))
            {
                while (true)
                {
                    if (ops.peek().equals("("))
                    {
                        ops.pop();
                        break;
                    }
                    output.add(ops.pop());
                }
            }
            else if(!token.equals(""))
            {
                //must be number; push to output
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
    public static double solvePostFix(ArrayList<String> input)
    {
        //create stack to store working values
        Stack<Double> values = new Stack<>();
        double num1;
        double num2;
        //loop thorugh all values
        for (String value : input)
        {
            //check if operator
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
            else
            {
                values.push(Double.parseDouble(value));
            }
        }
        //should be one value left
        return values.pop();
    }
}