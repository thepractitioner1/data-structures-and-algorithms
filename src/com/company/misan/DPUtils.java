package com.company.misan;

import java.util.ArrayList;
import java.util.HashMap;

public class DPUtils {
    public static long fibronacci(int n){
        var map = new  HashMap<Integer, Long>();
        return fibronacci(n, map);

    }

    public static long gridTraveler(int m, int n){
        var memo = new HashMap<String, Long>();
        return gridTraveler(m, n, memo);
    }
    public static  boolean canSum(ArrayList<Integer> list, int target){
        var memo = new HashMap<Integer, Boolean>();
        return canSum(list, target);
    }

    private static boolean canSum(ArrayList<Integer> list, int target, HashMap<Integer,Boolean> memo ){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target< 0 ) return false;

        for(int number: list){
            System.out.println(number);
            int remainder = target - number;
            if(canSum(list, remainder)){
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return  false;
    }

    private static long fibronacci(int n, HashMap<Integer, Long> map){
        if(n < 2) return n;
        if(map.containsKey(n)) return map.get(n);
        var result = fibronacci(n-1, map) + fibronacci(n-2, map);
        map.put(n, result);
        return  result;
    }

    private static long gridTraveler(int m, int n, HashMap<String,Long> map){
        String key = m + "," + n;
        if(map.containsKey(key)) return map.get(key);
        System.out.println(key);
        if( m == 1) return 1;
        if(n == 0 || m == 0) return 0;

       var result = gridTraveler(m -1, n, map) + gridTraveler(m, n-1, map);
        map.put(key,result);
       return result;
    }



}
