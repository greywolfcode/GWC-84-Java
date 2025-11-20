import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //call starting render
        Renderer.render();
        //define objects
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();
        //set up action prompt
        CursorControl.goTo(0, 55);
        System.out.print("Your Action: ");
        String inputLine = "";
        String action = "";
        //main loop
        while (true)
        {
            //get action
            inputLine = input.nextLine();
            action = inputLine.trim();

            //handle action and check if turning off
            if (calc.handleInput(action))
            {
                break;
            }
            
            //reset cursor and clear line
            CursorControl.goTo(14, 55);
            System.out.print(" ".repeat(inputLine.length()));
            CursorControl.goTo(14, 55);
        }
    }
}