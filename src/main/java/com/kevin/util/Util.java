package com.kevin.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

    public static int[] getRandomArr(int length) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
