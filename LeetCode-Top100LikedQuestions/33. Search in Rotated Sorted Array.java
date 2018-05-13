package Test;

public class SearchInRotatedSortedArray_33 {

	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[start] <= nums[mid] && !(target >= nums[start] && target < nums[mid]))
				start = mid + 1;
			else if (nums[start] <= nums[mid] && (target >= nums[start] && target < nums[mid]))
				end = mid - 1;
			else if (nums[start] >= nums[mid] && (target <= nums[end] && target > nums[mid]))
				start = mid + 1;
			else
				end = mid - 1;

		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println("Element is at index : " + search(nums, target));
	}

}
