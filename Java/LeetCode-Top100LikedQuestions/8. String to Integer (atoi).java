
class Solution {
	public static int myAtoi(String str) {
		if(str.equals(""))
			return 0;
		
		String myString = str.trim();
		String stringSplit[] = myString.split(" ");
		String workingString = stringSplit[0];
		String testString = "2147483647";
		boolean isSigned = false;
		int number = 0;

		if (workingString.substring(0, 1).equals("+") || workingString.substring(0, 1).equals("-")) {
            if(workingString.length()<2)
                return 0;
			for (int i = 1; i < workingString.length(); i++) {
				if (!Character.isDigit(workingString.charAt(i))) {
					workingString=workingString.substring(0,i);
				}
			}

			if (workingString.length() > 11) {
				return Integer.MAX_VALUE;
			} else if (workingString.length() == 11){
				for (int k = 1; k < workingString.length(); k++) {
					if (Integer.parseInt(workingString.charAt(k) + "") > Integer.parseInt(testString.charAt(k) + "")) {
						return Integer.MAX_VALUE;
					} 
				}
				number = Integer.parseInt(workingString);
				return number;
			}
			number = Integer.parseInt(workingString);
			return number;
		} else {
			for (int i = 0; i < workingString.length(); i++) {
				if (!Character.isDigit(workingString.charAt(i))) {
					workingString=workingString.substring(0,i);
				}
			}

			if (workingString.length() > 10) {
				return Integer.MAX_VALUE;
			} else if (workingString.length() == 10){
				for (int k = 0; k < workingString.length(); k++) {
					if (Integer.parseInt(workingString.charAt(k) + "") > Integer.parseInt(testString.charAt(k) + "")) {
						return Integer.MAX_VALUE;
					}
					
				}
				number = Integer.parseInt(workingString);
				return number;
			}
			number = Integer.parseInt(workingString);
			return number;
		}

	
	}
}
