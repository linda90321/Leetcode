/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Hide Company Tags LinkedIn Bloomberg Uber Facebook Microsoft
Hide Tags Binary Search Array
Hide Similar Problems (M) Search in Rotated Sorted Array II (M) Find Minimum in Rotated Sorted Array
*/
public class SearchInRotatedSortedArray33 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[mid] >= nums[start]) {
				if (nums[start] <= target && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (target <= nums[end] && target > nums[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}

		return -1;
	}
}
