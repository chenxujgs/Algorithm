package suanfa.likou.A20220704;

/**
 * 有序,二分找到指定的值
 */
public class likou35 {
    public static void main(String[] args) {
        //System.out.println(10/2);
        System.out.println(likou35.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, mid = 0, end = nums.length - 1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return target > nums[mid] ? mid + 1 : mid;
    }
}