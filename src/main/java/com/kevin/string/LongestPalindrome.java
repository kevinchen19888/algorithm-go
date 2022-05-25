package com.kevin.string;

/**
 * 最长回文字串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 思路:
 * 1,双重for遍历字符获取所有可能的由字符组成的字符串,然后判断每个子串是否是回文子串,如果是就将对应子串赋给result,
 * 并临时将其置给最大回文子串长度max;
 * 2,迭代判断直到结束,从而可以获取最大回文子串
 *
 * @author kevin chen
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(longestPalindrome(s));
    }

    // 暴力解法
    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <=len; j++) {
                String childStr = s.substring(i, j);
                if (isPalindromic(childStr) && childStr.length() > max) {
                    result = childStr;
                    max = Math.max(max, childStr.length());
                }
            }
        }
        return result;
    }

    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
