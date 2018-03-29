class Solution {
   public static int maxArea(int[] height) {
		int maxArea = Integer.MIN_VALUE;
		int currArea = Integer.MIN_VALUE;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			int width = Math.abs(start - end);
			int minHeight = Math.min(height[start], height[end]);
			currArea = minHeight * width;
			if (height[start] > height[end])
				end--;
			else
				start++;
			if (currArea > maxArea)
				maxArea = currArea;
		}
		return maxArea;
	}
}
