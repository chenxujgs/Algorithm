package suanfa.likou.A20220802;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */
public class likou315 {
    public static void main(String[] args) {
        System.out.println(new likou315().countSmaller1(new int[]{5, 2, 6, 1}));
    }

    public List<Integer> countSmaller1(int[] nums) {
        int length = nums.length;
        int[] indices = new int[length];
        for (int i = 0; i < length; i++) {
            indices[i] = i;
        }
        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            counts.add(0);
        }
        for (int halfLength = 1, currLength = 2; halfLength < length; halfLength *= 2, currLength *= 2) {
            for (int low = 0; low < length - halfLength; low += currLength) {
                int mid = low + halfLength - 1;
                int high = Math.min(low + currLength - 1, length - 1);
                merge(nums, indices, counts, low, mid, high);
            }
        }
        return counts;
    }

    public void merge(int[] nums, int[] indices, List<Integer> counts, int low, int mid, int high) {
        int currLength = high - low + 1;
        int[] tempNums = new int[currLength];
        int[] tempIndices = new int[currLength];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                tempNums[k] = nums[i];
                tempIndices[k] = indices[i];
                counts.set(indices[i], counts.get(indices[i]) + (j - mid - 1));
                i++;
            } else {
                tempNums[k] = nums[j];
                tempIndices[k] = indices[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            tempNums[k] = nums[i];
            tempIndices[k] = indices[i];
            counts.set(indices[i], counts.get(indices[i]) + (j - mid - 1));
            i++;
            k++;
        }
        while (j <= high) {
            tempNums[k] = nums[j];
            tempIndices[k] = indices[j];
            j++;
            k++;
        }
        System.arraycopy(tempNums, 0, nums, low, currLength);
        System.arraycopy(tempIndices, 0, indices, low, currLength);
    }

    /**
     * 暴力法,超时
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int left = 0, right = left + 1;
        while (left < len) {
            int temp = 0;
            while (right < len) {
                if (nums[left] > nums[right]) {
                    temp++;
                }
                right++;
            }
            left++;
            right = left + 1;
            list.add(temp);
        }
        return list;
    }
}
