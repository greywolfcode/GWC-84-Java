//import standard libraries
import java.util.Stack;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Calculate 
{
    private Calculate(){}
    
    /**
     * creates postfix with Shunting Yard algorithm
     */
    public static ArrayList toPostFix(String input)
    {
        //create output ArrayList
        ArrayList<String> output = new ArrayList<>();
        
        //loop until all charachters are used
        int index = 0; //using seperate index to help with ()
        Stack<String> operators = new Stack<>();
        String currentToken = "";
        StringBuilder currentNumber = new StringBuilder();
        while (true)
        {
            currentToken = input.substring(index, index+1);
            //check if whole string is used
            if (input.length() == index)
            {
                break;
            }
            //check if charachter is a digit
            if (Character.isDigit(currentToken))
            {
                currentNumber.append(currentToken);
            }
            else if(currentToken.equals("-"))
            {
                
            }
            
            index++;
            
            
        }
        return output;
    }
    public static String solvePostFix(String[] input)
    {
        return "";
    }
}