package GWC_84_Java;

//import standard libraries
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.IOException;

//import MathObject stuff
import MathObjects.MathObject;
import MathObjects.Numbers.Decimal;

/**
 * Collection of methods for handling save files
 */
public class FileHandling 
{
    private static String saveDataPath = "SaveData.conf";
    private static Data data;
    //variables for storing data when loading files
    private static boolean loadedSave;
    private static String defaultSavePath = "saves/";
    private static int defaultSaveFile = 1;
    private static String[] paths = new String[6];
    
    private FileHandling(){}
    
    /**
     * loads saveData.txt to prepeare for saving/loading save files
     */
    public static void fileHandlingInit(Data storage)
    {
        data = storage;
        
        try(Scanner file = new Scanner(new File(saveDataPath)))
        {
            defaultSavePath = file.nextLine();
            defaultSaveFile = file.nextInt();
            //get all paths
            while (file.hasNext())
            {
                int saveNum = file.nextInt();
                if (saveNum <= 6)
                {
                    paths[saveNum-1] = file.nextLine();
                }
                else
                {
                    file.nextLine();
                }
            }
            loadedSave = true;
        }
        catch (IOException e)
        {
            loadedSave = false;
            for (int i = paths.length-1; i >= 0; i--)
            {
                paths[i] = "none";
            }
            remakeSaveDataFile();
        }
        catch (InputMismatchException e)
        {
            
        }
    }
    public void saveFile()      
    {          
        try (FileOutputStream file = new FileOutputStream("../saves/save1.bin"))          
        {                       
           //write header
           file.write("GWC".getBytes()); //write magic bytes
           file.write(1); //currently version 1
           file.write("\u2028".getBytes()); //write block end
           //write history block
           ArrayList<ArrayList<ArrayList<MathObject>>> history = data.getFullHistory();
           for (ArrayList<ArrayList<MathObject>> group:history)
           {
               
           }
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
    private static void remakeSaveDataFile()
    {
        try (PrintWriter file = new PrintWriter(saveDataPath))
        {
            file.println(defaultSavePath);
            file.println(defaultSaveFile);
            for (int i=paths.length; i>0; i--)
            {
                file.print(i + " ");
                file.println(paths[i-1]);
            }
        }
        catch (IOException e)
        {
            
        }
    }
}