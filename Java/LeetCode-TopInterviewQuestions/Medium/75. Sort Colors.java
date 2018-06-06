class Solution {
    public static void sortColors(int[] nums) {

		int i = 0;
		int j = nums.length - 1;
		int k = 0;
		for (; i < nums.length && nums[i] == 0;) {
			i++;
		}
		for (; j >= 0 && nums[j] == 2;) {
			j--;
		}
		if (i > nums.length-1 || j<0) {
			return;
        }
            k=i;
			while (j >= k) {
				if (nums[k] != 1) {
					if (nums[k] == 0) {
						swap(nums, k, i);
						k++;i++;
					} else {
						swap(nums, k, j);
						j--;
					}
				} else {
					k++;
				}
			}
	}

	public static void swap(int nums[], int i, int j) {
		if (i >= 0 && i <= nums.length - 1 && j >= 0 && j <= nums.length - 1 && i != j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
