package todoly.model;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Date implements Comparable<Date>, Serializable {
    private static final long serialVersionUID = 5865782137277972768L;
    private LocalDate date;
    
    public Date(String date) throws BusinessModelException {
        set(date.trim());
    }

    public LocalDate get() {
        return date;
    }

    public void set(String date) throws BusinessModelException {
        int[] YearMonthDay = parseDate(date);
        
        try {
            this.date = LocalDate.of(YearMonthDay[0], YearMonthDay[1], YearMonthDay[2]);
        } catch (DateTimeException e) {
            throw new BusinessModelException(e.getMessage());
        }
    }

    private int[] parseDate(String date) throws BusinessModelException {
        String[] parts = date.split("-");
        
        if(parts.length!=3) {
            throw new BusinessModelException("The date must be composed of 3 parts: YYYY-MM-DD");
        }
        
        try {
            
            int value0 = Integer.parseInt(parts[0]);
            
            if(parts[0].length()!=4)
                throw new BusinessModelException("The year must be with 4 digits: YYYY");
            
            int[] YearMonthDay = {
                value0,
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2])
            };
            
            return YearMonthDay;
            
        } catch (NumberFormatException e) {
            String message = e.getMessage()
                              .replace("For input string", 
                                       "Wrong value"
                              );
            
            throw new BusinessModelException(message);
        }
    }

    @Override
    public String toString() {
        return date.toString();
    }

    @Override
    public int compareTo(Date other) {
        return date.compareTo(other.date);
    }
}
