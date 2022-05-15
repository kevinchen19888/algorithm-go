package com.kevin.sort;

import com.kevin.util.Util;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * 1.排序思想:
 * a.确定排序的基准数
 * b.通过左右哨兵进行查找,当右哨兵找到比基准值小的数时停下,然后左哨兵找到比基准值大数时也停下,最后进行交换
 * c.递归调用以上步骤
 * <p>
 * 2.平均时间复杂度O(NlogN)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(20);
        System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();

        quickSort(arr, 0, arr.length - 1);
        //  BubbleSort.bubbleSort(arr);
        System.out.println("排序结果:" + Arrays.toString(arr));
        System.out.println("排序耗费时间:" + (System.currentTimeMillis() - begin));
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = arr[left];// 选择第一个数作为基准值
        int i = left, j = right;
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
        // 交换基准值与哨兵交汇处的值
        swap(arr, j, left);

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
