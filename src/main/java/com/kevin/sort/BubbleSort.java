package com.kevin.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 7, 3, 8, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }


}
