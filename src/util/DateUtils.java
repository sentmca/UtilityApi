import java.sql.Timestamp;
import java.util.Calendar;

class DateUtils{
     public static Timestamp getFirstDayOfMonth(int Month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Month, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return new Timestamp(calendar.getTimeInMillis());
	}
			
	public static Timestamp getLastDayOfMonth(int Month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Month, 1);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, maxDay);
		return new Timestamp(calendar.getTimeInMillis());
	}
			
	public static java.sql.Timestamp nowTimestamp() {
		return getTimestamp(System.currentTimeMillis());
	}
		    
	public static java.sql.Timestamp getTimestamp(long time) {
		return new java.sql.Timestamp(time);
	}

}