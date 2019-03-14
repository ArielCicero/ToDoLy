package todoly.util;

/**
 * The <code>IsNumeric</code> class is a helper class used by the 
 * <code>ToDoLy</code> App.
 * The <code>IsNumeric</code> class checks if a string is a number in base-ten or not.
 * Inputs parameters like 0.379d or -0.24D, 15d are considered as doubles.
 * Inputs parameters like 3.8f, -3.87F, 32f are considered as floats.
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class IsNumeric {
    /**
     * This method checks if a string sent as a parameter is a number in base-ten or not.
     * 
     * @param str String
     * @return boolean flag, true if the string represents a number in base-ten, false otherwise
     */
    public static boolean check(String str) {
        if(isDouble(str) || isInteger(str) || isFloat(str)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the string parameter is a representation of a float number.
     * @param String to be checked
     * @return boolean flag, true if the string represents a float, false otherwise
     */
    private static boolean isFloat(String str) {
        try {  
            Float.parseFloat(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    /**
     * Checks if the string parameter is a representation of an integer number.
     * @param String to be checked
     * @return boolean flag, true if the string represents an integer, false otherwise
     */
    private static boolean isInteger(String str) {
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    /**
     * Checks if the string parameter is a representation of a double number.
     * @param String to be checked
     * @return boolean flag, true if the string represents a double, false otherwise
     */
    private static boolean isDouble(String str) {
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }
}
