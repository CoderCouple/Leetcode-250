class Solution {
	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int currLength = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                	i = map.get(s.charAt(j));
                    map.clear();
                    if(currLength>maxLength)
                        maxLength=currLength;
                    currLength = 0;
                    break;
                } else{
                    map.put(s.charAt(j),j);
                    currLength++;
                }
            }
		}
		if(currLength>maxLength)
			maxLength=currLength;
		return maxLength;
	}
}
