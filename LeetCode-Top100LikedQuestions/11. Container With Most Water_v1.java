class Solution {
   public static int maxArea(int[] height) {
		int maxArea = Integer.MIN_VALUE;
		int currArea = Integer.MIN_VALUE;

		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < height.length; j++) {
				int width = Math.abs(i - j);
				int minHeight = Math.min(height[i], height[j]);
				currArea = minHeight * width;
				if (currArea > maxArea)
					maxArea = currArea;
			}
		}

		return maxArea;
	}

}
