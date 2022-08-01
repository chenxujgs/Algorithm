package suanfa.likou.A20220801;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
public class likou295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new likou295().new MedianFinder();
        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(13);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(15);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
    }

    /**
     * 思路: 主要是先排好序,这里使用二分插入排序,因为每次都会保证有序
     */
    class MedianFinder {
        private List<Integer> list;

        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            if (list.size() == 0) {
                list.add(num);
            } else {
                list.add(BinarySearchLoc(list, num), num);
            }

        }

        private int BinarySearchLoc(List<Integer> list, int num) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (list.get(mid) > num) {
                    left = mid + 1;
                } else if (list.get(mid) < num) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return left;
        }

        public double findMedian() {
            if ((list.size() % 2) != 0) {
                return list.get(list.size() / 2);
            } else {
                int size = list.size() + 1;
                return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;

            }
        }
    }

}
