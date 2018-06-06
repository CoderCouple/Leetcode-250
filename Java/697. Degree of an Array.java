class Solution {
   public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> startIndex = new HashMap<Integer, Integer>();
		Map<Integer, Integer> endIndex = new HashMap<Integer, Integer>();
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (frequency.containsKey(nums[i])) {
				frequency.put(nums[i], frequency.get(nums[i]) + 1);
				endIndex.put(nums[i], i);
			} else {
				frequency.put(nums[i], 1);
				startIndex.put(nums[i], i);
				endIndex.put(nums[i], i);
			}
		}

		int maxFrequency = Collections.max(frequency.values());
		int result = nums.length;

		for (int x : frequency.keySet()) {
			if (frequency.get(x) == maxFrequency) {
				result = Math.min(endIndex.get(x) - startIndex.get(x)+1, result);
			}
		}
		
		return result;

	}
}
