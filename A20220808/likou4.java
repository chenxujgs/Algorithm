package suanfa.likou.A20220808;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class likou4 {
    public static void main(String[] args) {
        System.out.println(new likou4().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
        //new likou4().findMedianSortedArrays(new int[]{2}, new int[]{});
        // new likou4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3});

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, len = m + n;
        int[] nums = new int[len];
        for (int i = 0; i < n; i++) {
            nums[m + i] = nums2[i];
        }

        int begin = 0, begin1 = 0;
        int end = m;
        while (begin1 < m) {
            if (end<len&&nums1[begin1] > nums[end]) {
                nums[begin++] = nums[end++];
            } else {
                nums[begin++] = nums1[begin1++];
            }
        }
        m = len / 2;
        if (len % 2 == 1) {
            return nums[m];
        }
        return (nums[m - 1] + nums[m]) / 2.0;

    }
}
