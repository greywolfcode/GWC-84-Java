public class Calculator 
{
    private String state;
    public Calculator()
    {
        state = "main";
    }
    public boolean handleInput(String input)
    {
       //set enter mode to 2nd or alpha
       if (input.equals("2nd"))
       {
           if (state.equals("2nd"))
           {
               state = "main";
           }
           else
           {
               state = "2nd";
           }
       }
       else if (input.equals("alp"))
       {
           if (state.equals("alp"))
           {
               state = "main";
           }
           else
           {
               state = "alp";
           }
       }
        //check if need to turn off calculator
        else if (state.equals("2nd"))
        {
            if (input.equals("on") || input.equals("off"))
            {
                return true;
            }
        }
        //run menu event handler
        else
        {
            
        }
        return false;
    }
    
}