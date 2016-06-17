package utilities;

public class Numbers {
	public static boolean isInteger(String value) {
		try {
			Integer.valueOf ( value );
			return true;
		} catch ( NumberFormatException e){
			return false;
		}
	}

	public static boolean isFloat(String value) {
		try {
			Float.valueOf ( value );
			return true;
		} catch ( NumberFormatException e) {
			return false;
		}
	}


}
