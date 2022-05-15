package com.kevin.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Util {

    public static int[] getRandomArr(int length) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            list.add(i + 1);
        }
        Collections.shuffle(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 生成一个从1开始的(包含1)间隔为1,长度为length的有序数组
     *
     * @param length 数组长度
     * @return 有序数组
     */
    public static int[] getSortArr(int length) {
        return IntStream.rangeClosed(1, length).toArray();
    }

    public static IntStream getIntStream(int length) {
        return IntStream.rangeClosed(1, length);
    }




}
