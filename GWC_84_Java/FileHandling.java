package GWC_84_Java;

//import standard libraries
import java.util.Scanner;
import java.util.InputMismatchExcpetion;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.IOException;

/**
 * Collection of methods for handling save files
 */
public class FileHandling 
{
    private String saveDataPath = "saveData.txt"
    //variables for storing data when loading files
    private static boolean loadedSave;
    private static String defaultSavePath = "saves/";
    private static int defaultSaveFile = 1;
    private String[] paths = String[6];
    
    private static FileHandling(){}
    
    /**
     * loads saveData.txt to prepeare for sving/loading save files
     */
    public static void fileHandlingInit()
    {
        try(Scanner file = new Scanner(new File(saveDataPath)))
        {
            if (file.hasNext())
            {
                defaultSavepath = file.nextLine();
            }
            if (file.hasNext())
            {
                try 
                {
                    defaultSaveFile = file.nextDouble();
                    file.nextLine(); //capture newline charachters
                }
                catch (InputMismatchExcpetion e)
                {
                    defaultSaveFile = 1;
                }
            }
            //get all paths
            while (file.hasNext())
            {
                int saveNum = Integer.parseInt(file.next());
                if (saveNum < 6)
                {
                    paths[saveNum] = file.nextline();
                }
            }
            loadedSave = true;
        }
        catch (IOException e)
        {
            loadedSave = false;
        }
    }
    public void saveFile()      
    {          
        try (FileOutputStream output = new FileOutputStream("../saves/save1.bin"))          
        {                       
            
        }          
        catch (IOException e)          
        {                        
            
        }      
    }      
    public void loadSave(int saveNum)      
    {          
        try (FileInputStream file = new FileInputStream(paths[saveNum]))          
        {                        
            
        }          
        catch (IOException e)          
        {                        
            
        }      
    }
    /**
     * method for remaking the saveData.txt file if it is missing/corrupted
     */
    private void remakeSaveDataFile()
    {
        try (PrintWriter file = new PrintWriter(saveDatapath))
        {
            
        }
        catch (IOException e)
        {
            
        }
    }
}