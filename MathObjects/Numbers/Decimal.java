package MathObjects.Numbers;

import java.lang.StringBuilder;
import java.math.BigDecimal;

/**
 * Class for storing and munipulating decimal obejcts
 */
public class Decimal extends Numbers
{
    //string builder so numbers can be added individually
    private StringBuilder value;
    //store where in the decimal is being selected
    private int selectedDigit = 0;
    
    /**
     * Merges an array of Decimal objects into a single object.
     * They are merged in the order of the array
     */
    public static Decimal merge(Decimal[] nums)
    {
        Decimal merged = new Decimal();
        for (Decimal num:nums)
        {
            merged.add(num);
        }
        return merged;
    }
    
    /**
     * Constructors
     */
    public Decimal(BigDecimal decimalValue)
    {
        setType("Decimal");
        value = new StringBuilder(decimalValue.toString());
    }
    public Decimal(String decimalValue)
    {
        setType("Decimal");
        value = new StringBuilder(decimalValue);
    }
    public Decimal(StringBuilder decimalValue)
    {
        setType("Decimal");
        value = decimalValue;
    }
    public Decimal(double decimalValue)
    {
        value = new StringBuilder(decimalValue + "");
        setType("Decimal");
    }
    public Decimal(long decimalValue)
    {
        value = new StringBuilder(decimalValue + "");
        setType("Decimal");
    }
    public Decimal()
    {
        value = new StringBuilder("");
        setType("Decimal");
    }
    
    /**
     * Method to add next digit or - or . to string
     * 
     * These do not perform addition
     */
    public void add(String charachter)
    {
        if (selected)
        {
            value.setCharAt(selectedDigit, charachter.charAt(0));
        }
        else
        {
            value.append(charachter);
        }
    }
    public void add(double newValue)
    {
        value.append(newValue + "");
    }
    public void add(int newValue)
    {
        value.append(newValue + "");
    }
    public void add(Decimal newValue)
    {
        value.append(newValue.toString());
    }
    
    public BigDecimal getValue()
    {
        //get string from StringBuilder, then convert to BigDecimal
        BigDecimal numValue = new BigDecimal(value.toString());
        //return value with correct rounding precision. TI-84+CE has 14 digits
        return numValue.setScale(14, BigDecimal.ROUND_HALF_UP);
    }
    public boolean isZero()
    {
       return getValue().compareTo(BigDecimal.ZERO) == 0; 
    }
    public boolean setSelected(String direction)
    {
        if (selected) //check if already selected
        {
            //check what direction the selection is moving
            if (direction.equals("a"))
            {
                if (selectedDigit == 0) //check if on first digit of decimal
                {
                    selected = false;
                    return true;
                }
                selectedDigit -= 1;
                return false;
            }
            else if (direction.equals("d"))
            {
                if (selectedDigit == value.length() - 1) //check if on last digit of decimal
                {
                    selected = false;
                    return true;
                }
                selectedDigit += 1;
                return false;
            }
            return false; //catch all
        }
        //check what direction is being moved and respond accordingly
        if (direction.equals("a"))
        {
            selectedDigit = value.length() - 1;
            selected = true;
            return false;
        }
        else if (direction.equals("d"))
        {
            selectedDigit = 0;
            selected = true;
            return false;
        }
        return false; //catch all in case of some wierd occurance
    }
    public Decimal[] split(boolean includeSelected)
    {
        //convert StringBuilder to String so String split method can be used
        String num = value.toString(); //Yes, it is a bit strange having "num" be a string not an int or double
        if (selectedDigit == num.length() - 1 && !includeSelected) //check if splitting will be out of bounds
        {
                Decimal[] splitNums = new Decimal[1];
                splitNums[0] = new Decimal(num.substring(0, selectedDigit));
                return splitNums;
        }
        else
        {
            Decimal[] splitNums = new Decimal[2];
            splitNums[0] = new Decimal(num.substring(0, selectedDigit));
            if (includeSelected)
            {
                splitNums[1] = new Decimal(num.substring(selectedDigit));
            }
            else
            {
                splitNums[1] = new Decimal(num.substring(selectedDigit + 1));
            }
            return splitNums;
        }
    }
    public void replace(String newValue)
    {
        value.replace(selectedDigit, selectedDigit+1, newValue);
    }
    public String toString()
    {
        //round value to up to 10 places if there is a decimal and the last charachter is not the decimal
        if (doRound() && (value.indexOf(".") != -1) && (value.charAt(value.length() - 1) != '.'))
        {
            BigDecimal num = getValue();
            //BigDecimal is immutable, so this will not break the stored 14 significant digits
            return num.setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
        }
        //this return will always be used if you are able to edit the decimal because doRound will be false
        String currentValue = value.toString();
        if (selected)
        {
            return currentValue.substring(0, selectedDigit) + getSelectedString(currentValue.substring(selectedDigit, selectedDigit+1)) + currentValue.substring(selectedDigit+1); 
        }
        //return full string if there is no decimal or just a decimal point
        return currentValue;
    }
}