package com.kevin.sort;

import java.util.Arrays;

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
        int[] arr = {20, 40, 32, 67, 40, 20, 89, 300};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int left, int right, int[] arr) {
        if (left > right) {
            return;
        }

        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
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
