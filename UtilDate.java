import java.sql.Timestamp;
import java.util.Calendar;

class UtilDate{
public static Timestamp getFirstDayOfMonth(int Month){
    Calendar calendar = Calendar.getInstance();
	    calendar.set(2012, Month, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	public static Timestamp getLastDayOfMonth(int Month){
		Calendar calendar = Calendar.getInstance();
		  calendar.set(2012, Month, 1);
		  int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		  calendar.set(Calendar.DAY_OF_MONTH, maxDay);
		return new Timestamp(calendar.getTimeInMillis());
	}

}