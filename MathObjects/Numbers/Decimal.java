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
    
    public Decimal(BigDecimal decimalValue)
    {
        setType("Decimal");
        value = new StringBuilder(decimalvalue.toString());
    }
    public Decimal(String decimalValue)
    {
        setType("Decimal");
        value = new StringBuilder(decimalValue);
    }
    public Decimal(double decimalValue)
    {
        value = new StringBuilder(decimalValue + "");
        setType("Decimal");
    }
    public Decimal(int decimalValue)
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
     */
    public void add(String charachter)
    {
        value.append(charachter);
    }
    public void add(double newValue)
    {
        value.append(newValue + "");
    }
    public void add(int newValue)
    {
        value.append(newValue + "");
    }
    public BigDecimal getValue()
    {
        //get string from StringBuilder, then convert to BigDecimal
        BigDecimal numValue = new BigDecimal(value.toString());
        //return value with correct rounding precision. TI-84+CE has 14 digits
        return numValue().setScale(14, BigDecimal.ROUND_HALF_UP);
    }
    public boolean isZero()
    {
       return getValue().compareTo(BigDecimal.ZERO); 
    }
    public String toString()
    {
        //round value to up to 10 places if there is a decimal and the last charachter is not the decimal
        if (doRound() && (value.indexOf(".") != -1) && value.charAt(value.length() - 1) != '.')
        {
            BigDecimal num = getValue();
            //BigDecimal is immutable, so this will not break the stored 14 significant digits
            return num.setScale(10, BigDecimal.ROUND_HALF_UP).toString();
        }
        //return full string if there is no decimal or just a decimal point
        return value.toString();
    }
}