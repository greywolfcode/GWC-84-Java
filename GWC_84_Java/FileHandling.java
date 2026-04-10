package GWC_84_Java;

//import standard libraries
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

import java.math.BigInteger;
import java.math.BigDecimal;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

//import MathObject stuff
import MathObjects.MathObject;
import MathObjects.MathObjectHelper;
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
    private static int currentSaveFile = 1;
    private static String[] paths = new String[6];
    
    private FileHandling(){}
    
    /**
     * loads SaveData.conf to prepeare for saving/loading save files
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
                if (saveNum > 0 && saveNum <= 6)
                {
                    paths[saveNum-1] = file.nextLine().trim();
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
        currentSaveFile = defaultSaveFile;
    }
    public static void saveFile() throws IOException
    {          
        //reset file path & name if it does not exist
        if (paths[currentSaveFile-1].equals("none"))
        {
            paths[currentSaveFile-1] = defaultSavePath + "save" + currentSaveFile + ".calcsave";
            remakeSaveDataFile();
        }
        
        //create directory if required
        String path = paths[currentSaveFile-1];
        Path dirs = Paths.get(path).getParent();
        Files.createDirectories(dirs);
        //write file
        try (FileOutputStream output = new FileOutputStream(paths[currentSaveFile-1]);
             DataOutputStream file = new DataOutputStream(output)) //using DataOutputStream so ints are written as 4 bytes          
        {                       
           //write header
           file.writeChars("G84"); //write magic bytes
           file.write(1); //currently version 1, only need 1 byte
           file.writeChars("\u0017"); //write block end
           /* write history block */
            ArrayList<ArrayList<ArrayList<MathObject>>> history = data.getFullHistory();
            //write number of groups
            file.writeInt(history.size());
            //each set of line/answer
            for (ArrayList<ArrayList<MathObject>> group:history)
            {
                //save each line
                for (ArrayList<MathObject> line:group)
                {
                    //write number of MathObjects in line
                    file.writeInt(line.size());
                    for (MathObject element:line)
                    {
                        //write id
                        file.write(element.getID()); //only need 1 byte
                        //check if is decimal
                        if (element.getID() == 19)
                        {
                            //write Decimal information
                            Decimal num = (Decimal)element;
                            file.writeInt(num.getScale()); //write scale as 4 bytes
                            byte[] unscaledValue = num.getUnscaledValue().toByteArray()  ;
                            file.writeInt(unscaledValue.length); //write number of bytes in unscaled value; int so this is 4 bytes
                            file.write(unscaledValue);
                        }
                    }
                }
                //write line end byte
                file.writeChars("\u2028");
            }
           file.writeChars("\u0017");
        }          
        catch (IOException e)          
        {                        
            /*
             * This should be caught by what calls the method
             * so something can be displayed to the user,
             * but doing it like this will close the files 
             * automatically.
             */
            throw e; 
        }      
    }      
    public static void loadSave() throws IOException   
    {          
        try (FileInputStream input = new FileInputStream(paths[currentSaveFile-1]);
             DataInputStream file = new DataInputStream(input))          
        {
            //check for magic bytes
            if (!(file.readChar() == 'G' && file.readChar() == '8' && file.readChar() == '4'))
            {
                return; //error occured
            }
            int version = file.readByte(); //read version
            if (!(file.readChar() == '\u0017'))
            {
                return; //error occured
            }
            /** Read history block */
            int currentLine = 0;
            boolean start = true;
            ArrayList<ArrayList<ArrayList<MathObject>>> history = new ArrayList<ArrayList<ArrayList<MathObject>>>();
            ArrayList<ArrayList<MathObject>> group = new ArrayList<ArrayList<MathObject>>();
            //loop 
            for (int numGroups=file.readInt(); numGroups > 0; numGroups--)
            {
                if (start)
                {
                    group = new ArrayList<ArrayList<MathObject>>();
                    start = false;
                }
                else if (currentLine == 0) //creat new group
                {
                    history.add(group);
                    group = new ArrayList<ArrayList<MathObject>>();
                    currentLine = 1;
                }
                else
                {
                    currentLine = 0;
                }
                
                ArrayList<MathObject> line = new ArrayList<MathObject>();
                for (int numObjects=file.readInt(); numObjects > 0; numObjects--)
                {
                    //read id
                    int id = file.readByte();
                    //check if ID is Decimal
                    if (id == 19)
                    {
                        int scale = file.readInt();
                        int numBytes = file.readInt();
                        byte[] unscaledBytes = new byte[numBytes];
                        file.read(unscaledBytes);
                        BigInteger unscaledValue = new BigInteger(unscaledBytes);
                        BigDecimal value = new BigDecimal(unscaledValue, scale);
                        line.add(new Decimal(value));
                        
                    }
                    else
                    {
                       line.add(MathObjectHelper.getObject(id, data)); 
                    }
                }
                group.add(line);
            }
            if (!(file.readChar() == '\u0017'))
            {
                return; //error occured
            }
        }          
        catch (IOException e)          
        {                        
            /*              
            * This should be caught by what calls the method              
            * so something can be displayed to the user,              
            * but doing it like this will close the files               
            * automatically.              
            */             
            throw e; 
        }      
    }
    /** Path/Default Path getters and setters */
    public static void setCurrentSave(int saveNum)
    {
        currentSaveFile = saveNum;
    }
    public static int getCurrentSave()
    {
        return currentSaveFile;
    }
    public static void setPath(String newPath, int num)
    {
        if (num >= 0 && num < 6)
        {
            paths[num] = newPath;
            remakeSaveDataFile();
        }
    }
    public static void resetPath(int num)
    {
        if (num >= 0 && num < 6)
        {
            paths[num] = defaultSavePath + "save" + num + ".calcsave";
        }
    }
    public static String getPath(int num)
    {
        if (num >= 0 && num < 6)
        {
            return paths[num];
        }
        return "UndefinedPath";
    }
    public static void setDefaultPath(String newDefault)
    {
        defaultSavePath = newDefault;
        remakeSaveDataFile();
    }
    public static String getDefaultPath()
    {
        return defaultSavePath;
    }
    public static int getDefaultSave()
    {
        return defaultSaveFile;
    }
    public static void setDefaultSave(int num)
    {
        if (num >= 0 && num <6)
        {
            defaultSaveFile = num;
            remakeSaveDataFile();
        }
    }
    
    /**
     * Method for remaking the SaveData.conf file if it is missing/corrupted/outdated
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