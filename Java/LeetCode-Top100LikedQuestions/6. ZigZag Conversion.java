class Solution {
    public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		StringBuilder output = new StringBuilder();
		int count = 1;
		StringBuilder[] result = new StringBuilder[numRows];

		for (int m = 0; m < result.length; m++) {
			result[m] = new StringBuilder();
		}

		result[0].append(s.charAt(0) + "");
		while (count < s.length()) {
			for (int i = 1; i < result.length; i++) {
				if (count < s.length()) {
					result[i].append(s.charAt(count) + "");
					count++;
				} else
					break;
			}

			for (int j = result.length - 2; j >= 0; j--) {
				if (count < s.length()) {
					result[j].append(s.charAt(count) + "");
					count++;
				} else
					break;
			}

		}

		for (int k = 0; k < result.length; k++) {
			output.append(result[k].toString());
		}

		return output.toString();
	}
}
