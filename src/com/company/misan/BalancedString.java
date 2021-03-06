package com.company.misan;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedString {

    private static final List<Character> leftBrackets = Arrays.asList(')', '}', ']', '>');
    private static final List<Character> rightBrackets = Arrays.asList('(', '{', '[', '<');

    public static boolean checkBalancedString(String input){
        Stack<Character> mystack = new Stack<>();
        for(char ch: input.toCharArray()){
            if(isLeftBracket(ch))
                mystack.push(ch);

            if(isRightBracket(ch)){
                if(mystack.isEmpty()) return false;
                var top  = mystack.pop();

                if(!match(top, ch)) return false;
            }

        }

        return mystack.isEmpty();

    }

    private static boolean isRightBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private static boolean isLeftBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private static boolean match(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }


}
