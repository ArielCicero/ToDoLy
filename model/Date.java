package todoly.model;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * The <code>Date</code> class belongs to the model of the <code>ToDoLy</code>
 * App, and it's a wraping of the <code>LocalDate</code> class with the goal of
 * implementing the functionality needed by the task's due date in this application.
 * The Date can not be before at the current from the system clock in the default
 * time-zone.
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
 * @see LocalDate
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class Date implements Comparable<Date>, Serializable {
    private static final long serialVersionUID = 5865782137277972768L;
    private LocalDate date;
    
    /**
     * @param String date formated as YYYY-MM-DD
     * @throws BusinessModelException
     */
    public Date(String date) throws BusinessModelException {
        set(date.trim());
    }

    /**
     * Setter of the LocalDate field
     * @return LocalDate object type
     */
    public LocalDate get() {
        return date;
    }

    /**
     * @param String date formated as YYYY-MM-DD
     * @throws BusinessModelException when the year, the month or the
     * day are not valid or in case
     * the user insert a date before than the current one.
     * @see LocalDate
     */
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
    
    /**
     * @param LocalDate to compare with the the current date 
     * from the system clock in the default time-zone.
     * @return boolean flag indicating the result of the comparison.
     * true if this date belongs to the past; false otherwise.
     * @see LocalDate
     */
    private boolean isPastDate(LocalDate date) {
        return LocalDate.now().compareTo(date) > 0;
    }
    
    /**
     * @param String date formated as YYYY-MM-DD
     * @return int[] size 3. Indexes: [0]YYYY [1]MM [2]DD
     * @throws BusinessModelException when the year, the month or the day are not valid.
     */
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

    /**
     * Outputs this date as a String.
     * @return String representing the date
     */
    @Override
    public String toString() {
        return date.toString();
    }

    /**
     * Compares this date to another date.
     * @param otherDate
     * @return int representing the comparator value, negative if less,
     * positive if greater
     */
    @Override
    public int compareTo(Date otherDate) {
        return date.compareTo(otherDate.date);
    }
}
