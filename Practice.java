import java.time.*;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class Practice{
	public static void main(String args[]){
		Calendar calendar = Calendar.getInstance();
String dayName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG);
System.out.println("dayName = " + dayName);
      
	}
}