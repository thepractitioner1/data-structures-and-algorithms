package com.company.misan;

import java.util.HashMap;

public class DPUtils {
    public static long fibronacci(int n){
        var map = new  HashMap<Integer, Long>();
        return fibronacci(n, map);

    }

    private static long fibronacci(int n, HashMap<Integer, Long> map){
        if(n < 2) return n;
        if(map.containsKey(n)) return map.get(n);
        var result = fibronacci(n-1, map) + fibronacci(n-2, map);
        map.put(n, result);
        return  result;
    }
}
