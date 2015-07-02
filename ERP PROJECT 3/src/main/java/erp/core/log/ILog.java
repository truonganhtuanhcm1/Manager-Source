package erp.core.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ILog {
	
	private static String getCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static void Error(String title, Object sender, Exception ex) {
		
		System.out.println(String.format("[%s] [ERROR] %s " ,getCurrentDate(), title)); // Display the string.
		if (ex != null)
			System.out.println(String.format("[%s] [ERROR] Message: %s " ,getCurrentDate(), ex.getMessage())); // Display
																		// the
																		// string.
	}

	public static void Error(String title, Object sender) {
		System.out.println(String.format("[%s] [ERROR] %s " ,getCurrentDate(), title));
	}
	
	public static void Info(String title, Object sender) {
		System.out.println(String.format("[%s] [INFO] %s " ,getCurrentDate(), title));
	}
	
	public static void Debug(String title, Object sender) {
		System.out.println(String.format("[%s] [DEBUG] %s " ,getCurrentDate(), title));
	}
	
	public static void Warn(String title, Object sender) {
		System.out.println(String.format("[%s] [WARN] %s " ,getCurrentDate(), title));
	}
}
