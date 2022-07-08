package suanfa.likou.review;

public class likou189 {
    public static void main(String[] args) {
        likou189.rotate(new int[]{1,2,3,4,5,6,7},3);
        // n=7  k=3
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}

