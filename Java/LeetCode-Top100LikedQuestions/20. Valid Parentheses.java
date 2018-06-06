class Solution {
	Stack<Character> stk = new Stack<Character>();

	public boolean isOfOpeningType(char c) {
		if (c == '(' || c == '[' || c == '{')
			return true;
		return false;
	}

	public char getOpeningType(char c) {
		if (c == ')')
			return '(';

		if (c == ']')
			return '[';
 
			return '{';
	}

	public boolean isValid(String s) {
		if (s.length() == 0)
			return true;

		for (int i = 0; i < s.length(); i++) {
			if (isOfOpeningType(s.charAt(i)))
				stk.push(s.charAt(i));
			else {
				if (stk.isEmpty()) {
					return false;
				} else {
					if (stk.peek() == getOpeningType(s.charAt(i)))
						stk.pop();
					else
						return false;
				}

			}
		}
        if(!stk.isEmpty())
            return false;
		return true;
	}
}
