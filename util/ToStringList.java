package todoly.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The <code>ToStringList</code> class is a helper class used by the 
 * <code>ToDoLy</code> App.
 * The <code>ToStringList</code> class implements the logic to convert
 * a List of objects to a list of strings. For that purpose it uses its
 * own method convert.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class ToStringList {
    /**
     * @param List<T> representing a list of objects to be converted to a list of strings
     * @return List<String> representing the list of strings after aplaying to each element
     * the toString() method.
     */
    public static <T> List<String> convert(List<T> list){
        if(list != null)
            return list.stream().map(x->x.toString()).collect(Collectors.toList());
        else
            return null;
    }
}
