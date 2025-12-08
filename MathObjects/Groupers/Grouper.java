package MathObjects.Groupers;

import MathObjects.MathObject;

/**
 * Base class for all grouping symbols
 */
public abstract class Grouper extends MathObject
{
    private String side;
    private String grouperType;
    
    /**
     * Getters and setters for if the symbol is the right or left version
     */
     protected void setSide(String sideValue)
     {
         side = sideValue;
     }
     public String getSide()
     {
         return side;
     }
     /**
      * Getters and setters for what type of symbol it is
      * - round: ()
      * - square: []
      * - curly: {}
      */
      protected void setGrouperType(String type)
      {
          grouperType = type;
      }
      public String getGrouperType()
      {
          return grouperType;
      }
}