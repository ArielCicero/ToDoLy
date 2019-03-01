package todoly.model;

import java.time.DateTimeException;
import java.time.LocalDate;

import todoly.exceptions.ToDoLyException;

public class Date{
	private LocalDate date;
	
	public Date(String date) throws ToDoLyException {
		set(date);
	}

	public int compareTo(Date other) {
		return date.compareTo(other.get());
	}

	public LocalDate get() {
		return date;
	}

	public void set(String date) throws ToDoLyException {
		int[] YearMonthDay = parseDate(date);
		
		try {
			this.date = LocalDate.of(YearMonthDay[0], YearMonthDay[1], YearMonthDay[2]);
		} catch (DateTimeException e) {
			throw new ToDoLyException(e.getMessage());
		}
	}

	private int[] parseDate(String date) throws ToDoLyException {
		String[] parts = date.split("-");
		
		if(parts.length!=3) {
			throw new ToDoLyException("The date mus be composed of 3 parts: YYYY-MM-DD");
		}
		
		try {
			
			int value0 = Integer.parseInt(parts[0]);
			
			if(parts[0].length()!=4)
				throw new ToDoLyException("The year must be with 4 digits: YYYY");
			
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
			
			throw new ToDoLyException(message);
		}
	}

	@Override
	public String toString() {
		return date.toString();
	}
}
