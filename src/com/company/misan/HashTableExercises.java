package com.company.misan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTableExercises {
    public static int countPairsWithDiff(Integer[] args, int difference){
        int count = 0;
        int remainder;
        Set<Integer> uniqueSet = new HashSet<Integer>();
        uniqueSet.addAll(Arrays.asList(args));
        for(int i = 0; i< args.length; i++){
            remainder = args[i] - difference;
            if(uniqueSet.contains(remainder)) count++;
        }
        return count;
    }
}
