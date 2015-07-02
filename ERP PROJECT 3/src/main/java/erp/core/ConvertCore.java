package erp.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import erp.core.log.ILog;

public class ConvertCore {

	public static java.sql.Date ConvertToSqlDate(Date expDate) {

		if (expDate == null)
			return null;

		return new java.sql.Date(expDate.getTime());
	}
	
	/***
	 * Convert the date from util.Date type to sql.Timestamp
	 * @param targetDate
	 * @return
	 */
	public static java.sql.Timestamp ConvertToSqlTimestamp(Date targetDate) {

		if (targetDate == null)
			return null;

		return new java.sql.Timestamp(targetDate.getTime());
	}

	public static Date StringToDate(String _strDate, String _format) {
		if(_strDate==""){
			return null;
		}
		DateFormat format = new SimpleDateFormat(_format, Locale.ENGLISH);

		java.util.Date expDate = null;
		try {
			expDate = format.parse(_strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expDate;
	}
	

	public static String DateToString(java.sql.Date birth_date, String format) {
		// TODO Auto-generated method stub
		try {
			// Create an instance of SimpleDateFormat used for formatting
			// the string representation of date (month/day/year)
			DateFormat df = new SimpleDateFormat(format);

			// Get the date today using Calendar object.
			Date today = Calendar.getInstance().getTime();
			// Using DateFormat format method we can create a string
			// representation of a date with the defined format.
			String reportDate = df.format(today);
			return reportDate;
		} catch (Exception e) {
			ILog.Error("Convert date to string: " + birth_date, null);
			return "";
		}
	}
}
