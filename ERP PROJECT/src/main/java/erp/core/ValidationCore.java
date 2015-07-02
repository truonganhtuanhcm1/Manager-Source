package erp.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCore {

	public static boolean validUsername(String username) {
		// TODO Auto-generated method stub
		Pattern pattern;
		Matcher matcher;

		String USERNAME_PATTERN = "^[a-z0-9_-]{5,15}$";
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(username);
		return matcher.matches();
	}

	public static boolean validEmail(String email) {
		// TODO Auto-generated method stub
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}

	public static boolean validPassword(String password) {
		// TODO Auto-generated method stub
		Pattern pattern;
		Matcher matcher;

		String PASSWORD_PATTERN = "^[a-z0-9_-]{5,15}$";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	public static boolean validPhone(String phone) {
		// TODO Auto-generated method stub
		Pattern pattern;
		Matcher matcher;

		String PASSWORD_PATTERN = "^[0-9_-]{10,11}$";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(phone);
		return matcher.matches();
	}

}
