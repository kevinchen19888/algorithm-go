package com.kevin.linkedlist;

/**
 * 问题:给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线
 * <p/>
 * 示例：
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class FindMaxArea {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = getMaxArea(arr);
        System.out.println(maxArea);
    }

    private static int getMaxArea(int[] arr) {
        // 思路:基于贪心算法实现,假设两端的数据组成的面积为最大面积:maxArea,
        // 然后基于二分法逐次选取垂直线,与maxArea 进行对比,最后可以找到最大面积
        int left = 0;
        int right = arr.length - 1;
        int length = right - left + 1;
        int high = Math.min(arr[left], arr[right]);
        int maxArea = length * high;

        while (left != right) {
            if (arr[left] <= arr[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }

            int x = right - left;
            int tempHigh = Math.min(arr[left], arr[right]);
            int tempArea = x * tempHigh;
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
        }

        return maxArea;
    }

}
