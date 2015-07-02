package erp.core;

import java.util.UUID;

public class Utils {

	public static String GenKey() {

		return UUID.randomUUID().toString();
	}
}
