package com.kevin.search;

/**
 * 二分查找
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 9, 11};
        System.out.println(biSearch(arr, 9));
    }

    public static int biSearch(int[] arr, int target) {
        int l = 0, h = arr.length;
        while (l < h) {
            int mid = (h + l - 1) / 2;// 减掉1位,因为下标从0开始
            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
