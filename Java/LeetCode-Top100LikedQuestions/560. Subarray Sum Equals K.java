class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
		int cumulativeSum[] = new int[nums.length];
		cumulativeSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cumulativeSum[i] = cumulativeSum[i - 1] + nums[i];
		}
		 //System.out.println(Arrays.toString(cumulativeSum));

		for (int j = 0; j < cumulativeSum.length - 1; j++) {
			for (int l = j + 1; l < cumulativeSum.length; l++) {

				int total=cumulativeSum[l] - cumulativeSum[j];
				if (total == k)
				 result=result+1;

			}
		}
        
        for (int l = 0; l < cumulativeSum.length; l++) {
			if (cumulativeSum[l] == k)
				result++;

		}
		return result;
    }
}
