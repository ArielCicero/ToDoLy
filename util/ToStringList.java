package todoly.util;

import java.util.List;
import java.util.stream.Collectors;

public class ToStringList {
    public static <T> List<String> convert(List<T> list){
        if(list != null)
            return list.stream().map(x->x.toString()).collect(Collectors.toList());
        else
            return null;
    }
}
