package com.kevin.sort;

import com.kevin.util.Util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10);
        System.out.println(Arrays.toString(arr));;
        selectSort(arr);
        System.out.println(Arrays.toString(arr));;
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

}
