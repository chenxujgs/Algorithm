package suanfa.likou.review;

public class likou162 {
    public static void main(String[] args) {
        System.out.println(likou162.findPeakElement(new int[]{1, 2, 3, 1}));
    }
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
