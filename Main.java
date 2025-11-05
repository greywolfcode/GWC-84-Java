import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //define objects
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();
        //call starting render
        Renderer.render();
        System.out.print("Your Action: ");
        String action = "";
        //main loop
        while (true)
        {
            //get action
            action = input.nextLine();
            
            //handle action and check if turning off
            if (calc.handleInput(action))
            {
                break;
            }
            
            //reset cursor and clear line
            CursorControl.goTo(14,39);
            System.out.print(" ".repeat(action.length()));
            CursorControl.goTo(14,39);
        }
    }
}