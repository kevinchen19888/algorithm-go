package com.kevin.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 * <p>
 * 1.排序思想:
 * a.确定排序的基准书
 * b.通过左右哨兵进行查找,当右哨兵找到比基准值小的数时停下,然后左哨兵找到比基准值大数时也停下,最后进行交换
 * c.递归调用以上步骤
 * <p>
 * 2.平均时间复杂度O(NlogN)
 */
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        Integer[] rawArr = list.toArray(new Integer[0]);
        int[] arr = Arrays.stream(rawArr).mapToInt(a -> a).toArray();

        long begin = System.currentTimeMillis();
       // quickSort(0, arr.length - 1, arr);
        BubbleSort.bubbleSort(arr);
        System.out.println("排序耗费时间:" + (System.currentTimeMillis() - begin));
    }

    private static void quickSort(int left, int right, int[] arr) {
        if (left >= right) {
            return;
        }
        // 选择第一个数作为基准值
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            // 从右往左找出第一个比基准值小的
            while (arr[j] >= base && i < j) {
                j--;
            }
            // 从左往右找出第一个比基准值大的
            while (arr[i] <= base && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        // 最后交换基准值和哨兵交汇位置的值
        swap(arr, i, left);

        quickSort(left, i - 1, arr);
        quickSort(i + 1, right, arr);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
