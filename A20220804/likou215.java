package suanfa.likou.A20220804;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class likou215 {
    public static void main(String[] args) {
        System.out.println(new likou215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        sortArray(nums);
        return nums[nums.length-k];
    }

    private static int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private static int[] sort(int[] nums, int start, int end) {
        if (nums.length < 1 || start < 0 || end >= nums.length || start > end) {
            return null;
        }

        // 将数据切割成独立的两部分,从哪分区的指示器
        int zoneIndex = partition(nums, start, end);
        if (zoneIndex > start) {
            sort(nums, start, zoneIndex - 1);
        }
        if (zoneIndex < end) {
            sort(nums, zoneIndex + 1, end);
        }

        return nums;
    }

    private static int partition(int[] nums, int start, int end) {
        // 只有一个元素,无需分区
        if (start == end) {
            return start;
        }
        // 随机挑选一个基准数
        int pivot = (int) (start + Math.random() * (end - start) + 1);
        // 分区指示器,初始值为分区头元素下标减1
        int zoneIndex = start - 1;

        swap(nums, pivot, end);

        // 本质上是随机选出一个数作为基准数,从 start 开始遍历,若遇到比 end 位置大的就进行更换
        // 利用分区指示器进行更换位置的元素的锁定,若遇到<nums[end] 的,分区指示器++; 若遇到>nums[end] 的,分区指示器不变,进行下一次循环;
        // 若下次循环遇到<nums[end] 的,此时满足 i > zoneIndex ,进行元素的更换
        for (int i = start; i <= end; i++) {
            if (nums[i] <= nums[end]) {
                zoneIndex++;
                if (i > zoneIndex) {
                    swap(nums, i, zoneIndex);
                }
            }

        }
        return zoneIndex;
    }

    private static void swap(int[] arr, int i, int indexMin) {
        int temp = arr[i];
        arr[i] = arr[indexMin];
        arr[indexMin] = temp;
    }
}
