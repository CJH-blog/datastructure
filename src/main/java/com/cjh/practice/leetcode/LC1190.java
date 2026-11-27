package com.cjh.practice.leetcode;

import java.util.*;

public class LC1190 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses("(abcd)"));
    }


    static class Solution {
        public String reverseParentheses(String s) {
            int[] link = new int[s.length()];
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    stack.push(i);
                }else if(s.charAt(i)==')'){
                    int tmp = stack.pop();
                    link[i] = tmp;
                    link[tmp] = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            int dir = 1;
            for(int i=0;i<s.length();i+=dir){
                if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    sb.append(s.charAt(i));
                }else{
                    dir = -dir;
                    i = link[i];
                }
            }
            return sb.toString();
        }
    }
}
