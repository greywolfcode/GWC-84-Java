package MathObjects.Numbers;

import java.lang.StringBuilder;
import java.text.DecimalFormat;
import java.math.RoundingMode;

/**
 * Class for storing and munipulating decimal obejcts
 */
public class Decimal extends Numbers
{
    //string builder so numbers can be added individually
    private StringBuilder value;
    private DecimalFormat format;

    public Decimal(String decimalValue)
    {
        setType("Decimal");
        value = new StringBuilder(decimalValue);
        setRoundingFormat();
    }
    public Decimal(double decimalValue)
    {
        value = new StringBuilder(decimalValue + "");
        setType("Decimal");
        setRoundingFormat();
    }
    public Decimal(int decimalValue)
    {
        value = new StringBuilder(decimalValue + "");
        setType("Decimal");
        setRoundingFormat();
    }
    public Decimal()
    {
        value = new StringBuilder("");
        setType("Decimal");
        setRoundingFormat();
    }
    private void setRoundingFormat()
    {
        format = new DecimalFormat("#.##########");
        format.setRoundingMode(RoundingMode.HALF_UP);
        //only want to round some of the time
        setRound(false);
    }
    /**
     * Method to add next digit or - or . to string
     */
    public void add(String charachter)
    {
        value.append(charachter);
    }
    public void add(double newValue)
    {
        value.append(newValue + "");
    }
    public double getValue()
    {
        //get string from StringBuilder, then parse to double
        return Double.parseDouble(value.toString());
    }
    public boolean isZero()
    {
       return getValue() == 0; 
    }
    public String toString()
    {
        //round value to up to 10 places if there is a decimal and the last charachter is not the decimal
        if (doRound() && (value.indexOf(".") != -1) && value.charAt(value.length() - 1) != '.')
        {
            double num = getValue();
            return format.format(num);
        }
        //return full string if ther is no decimal
        return value.toString();
    }
}