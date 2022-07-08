package suanfa.likou.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cxj
 * @date 2022/3/13
 * @description
 */
public class likou6031 {
    public static void main(String[] args) {
        System.out.println(new likou6031().findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                tmp.add(i);
            }
        }
        for (Integer num : tmp) {
            for (int i = 0; i < n; i++) {
                if (list.contains(i)) continue;
                if (Math.abs(i - num) <= k) {
                    list.add(i);
                }
            }
        }
        
       Collections.sort(list);
        return list;
    }
}
