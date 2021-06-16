package javaalgos;

import java.util.*;

public class LISApp {

    public static int maxMissilesIntercepted(int[] tests) {
        assert tests != null;
        assert tests.length > 0;
        System.out.println(Arrays.toString(tests));
        int n = tests.length;
        int[] LIS = new int[n];
        LIS[0] = 1;
        int max = LIS[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (tests[j] > tests[i]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
            max = Math.max(max, LIS[i]);
        }
        System.out.println(Arrays.toString(LIS));
        return max;
    }
}