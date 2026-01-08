package MathObjects.Symbols;

import GWC_84_Java.Data;

import MathObjects.Numbers.Decimal;

/**
 * Stores all cases that refrence the previous answer
 */
public class Ans extends Symbol
{
    private Data data; //refrence to data to retrive last value
    
    public Ans(Data storage)
    {
        setValue(0.0);
        data = storage;
    }
    @Override
    public Decimal getValue()
    {
        try
        {
            //get Arraylist, then answer ArrayList, then MathObject, then convert to MathObject string then to decimal
            return new Decimal(data.getHistory(0).get(1).get(0).toString());
        }
        //run default method if cannot retrieve previous value
        catch (Exception e)
        {
            System.out.println(e);
            return super.getValue();
        }
    }
    public String toString()
    {
        return "Ans";
    }
}