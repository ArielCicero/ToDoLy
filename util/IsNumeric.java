package todoly.util;

public class IsNumeric {
    public static boolean check(String str) {
        if(isDouble(str) || isInteger(str) || isFloat(str)) {
            return true;
        }
        return false;
    }

    public static boolean isFloat(String str) {
        try {  
            Float.parseFloat(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    public static boolean isInteger(String str) {
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }

    public static boolean isDouble(String str) {
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }
    }
}
