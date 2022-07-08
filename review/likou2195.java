package suanfa.likou.review;

import java.util.Arrays;

/**
 * @author cxj
 * @date 2022/3/12
 * @description
 */
public class likou2195 {
    public static void main(String[] args) {
        System.out.println(new likou2195().minimalKSum(new int[]{53,41,90,33,84,26,50,32,63,47,66,43,29,88,71,28,83}, 76));
        //System.out.println(new likou2195().minimalKSum(new int[]{5,8},6));
    }

    public long minimalKSum1(int[] nums, int k) {
        Arrays.sort(nums);

        long ans=0,start=1;
        for (int i = 0; i <nums.length&&k>0 ; i++) {
            if(start<nums[i]){
                int cut= nums[i]-start>k?k: (int) (nums[i] - start);
                ans+=(2L*start+cut-1)*cut/2;
                k-=cut;
            }
            start=nums[i]+1;
        }
        // 不存在的数据累计
        if (k > 0) {
            ans += (2L * start + k - 1) * k / 2;
        }

      return ans;
    }
    public long minimalKSum(int[] nums, int k) {
        int res = 0;
        int add = 1;
        Arrays.sort(nums);

        int index = 0, n = nums.length;
        while (k > 0) {
            if (index == n) {
                res += getSum(nums[index - 1] + 1, k);
                break;
            }
            while (index < n) {
                int tmp = nums[index] - add;
                if (tmp > 0) {
                    if (tmp > k) {
                        res += getSum(add+1, k);
                        k = 0;
                        break;
                    } else {
                        res += getSum(add, tmp);
                        k-=tmp;
                    }
                }
                add = nums[index]+1;
                index++;

            }
        }
        return res;
    }

    private int getSum(int a1, int n) {
        return a1 * n + (n * (n - 1) >> 1);
    }
}
