package todoly.util;

/**
 * The <code>IsNumeric</code> class is a helper class used by the 
 * <code>ToDoLy</code> App.
 * The <code>IsNumeric</code> class checks if a string is a number or not.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class IsNumeric {
    public static boolean check(String str) {
        if(isDouble(str) || isInteger(str) || isFloat(str)) {
            return true;
        }
        return false;
    }

    private static boolean isFloat(String str) {
        try {  
            Float.parseFloat(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    private static boolean isInteger(String str) {
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    private static boolean isDouble(String str) {
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }
}
