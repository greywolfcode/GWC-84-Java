package MathObjects;

import java.lang.StringBuilder;

/**
 * Class for storing and munipulating decimal obejcts
 */
public class Decimal extends MathObject
{
    //string builder so numbers can be added individually
    private StringBuilder value;
    
    public Decimal(String decimalValue)
    {
        value = new StringBuilder(decimalValue);
        setType("Decimal");
    }
    public Decimal(double decimalValue)
    {
        value = new StringBuilder(decimalValue + "");
        setType("Decimal");
    }
    /**
     * Method to add next digit or - or . to string
     */
    public add(String charachter)
    {
        value.append(charachter);
    }
    public add(double newValue)
    {
        value.append(newValue + "")
    }
    public double getValue()
    {
        //get string from StringBuilder, then parse to double
        return Double.parseDouble(value.toString());
    }
    public String toString()
    {
        return value.toString();
    }
}