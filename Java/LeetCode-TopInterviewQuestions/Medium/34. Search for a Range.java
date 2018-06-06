package Test;

import java.util.Arrays;

public class BinaryRangeSearch {

	public static int[] searchRange(int[] nums, int target) {

		int[] result = { -1, -1 };

		if (nums.length == 0)
			return result;
		if (nums.length == 1 && nums[0] == target) {
			result[0] = result[1] = 0;
			return result;
		}

		result[0] = getLeftIndex(nums, 0, nums.length - 1, target);
		result[1] = getRightIndex(nums, 0, nums.length - 1, target);
		return result;
	}

	public static int getLeftIndex(int A[], int l, int r, int key) {
		if (A[l] == key)
			return l;

		int m;
		while (r - l > 1) {
			m = l + (r - l) / 2;

			if (A[m] < key)
				l = m;
			else
				r = m;
		}
		if (A[r] == key)
			return r;
		else
			return -1;
	}

	public static int getRightIndex(int A[], int l, int r, int key) {
		if (A[r] == key)
			return r;

		int m;
		while (r - l > 1) {
			m = l + (r - l) / 2;

			if (A[m] > key)
				r = m;
			else
				l = m;
		}
		if (A[l] == key)
			return l;
		else
			return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 5, 7, 7, 8, 8, 10 };
		int target =9;
		int result [] = searchRange(nums,target);
		System.out.println(Arrays.toString(result));
	}

}
