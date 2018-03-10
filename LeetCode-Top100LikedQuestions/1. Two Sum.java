class Solution {
  public static int[] twoSum(int[] nums, int target) {

		int result[] = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int check = target - nums[i];
			int index = i;

			if (map.containsKey(check)) {
				result[0] = i;
				result[1] = (int)map.get(check);
				return result;
			}

			map.put(nums[i], i);
		}

		return result;

	}
}
