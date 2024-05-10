package Ciber_PIC_Automation.Captiv;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timestamp {

	public static String getTimeStamp() {
	    Date date = Calendar.getInstance().getTime();

	    SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyHHmmss");

	    return formatter.format(date);
	}
	
	public static String getDateTime() {
	    Date date = Calendar.getInstance().getTime();

	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	    return formatter.format(date);
	}
	
}
	