package com.kevin.sort;

import com.kevin.util.Util;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 每次从未排序的数据中找到一个插入到已排好序的数组的合适位置处
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int preIdx = i - 1;
            while (preIdx >= 0 && arr[preIdx] > current) {
                arr[preIdx + 1] = arr[preIdx];
                preIdx--;
            }
            arr[preIdx + 1] = current;
        }
    }

}
