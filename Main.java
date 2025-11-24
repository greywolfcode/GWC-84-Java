import java.util.Scanner;
import ConsoleControl.Cursor;
import GWC_84_Java.Calculator;
import GWC_84_Java.Renderer;

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
        Cursor.goTo(0, 55);
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
            Cursor.goTo(14, 55);
            System.out.print(" ".repeat(inputLine.length()));
            Cursor.goTo(14, 55);
        }
    }
}