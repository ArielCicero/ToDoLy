package todoly.model;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * The <code>Date</code> class belongs to the model of the <code>ToDoLy</code>
 * App, and it's a wraping of the <code>LocalDate</code> class with the goal of
 * implementing the functionality needed by the task's due date in this application.
 * The Date can not be before at the current day of the creation.
 * 
 * The <code>Date</code> class implements the <code>Comparable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to order its tasks by
 * due date.
 * The <code>Date</code> class implements the <code>Serializable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to save its status in
 * a file.
 * The <code>Date</code> class throws <code>BusinessModelException</code>.
 *
 * @see Serializable
 * @see Comparable
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
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
        LocalDate newDate = null;
        try {
            newDate = LocalDate.of(YearMonthDay[0], YearMonthDay[1], YearMonthDay[2]);
            if(isPastDate(newDate)) {
                throw new BusinessModelException("The Date must be equal to today or a future date");
            }
            else {
                this.date = newDate;
            }
        } catch (DateTimeException e) {
            throw new BusinessModelException(e.getMessage());
        }
    }
    
    private boolean isPastDate(LocalDate date) {
        return LocalDate.now().compareTo(date) > 0;
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
