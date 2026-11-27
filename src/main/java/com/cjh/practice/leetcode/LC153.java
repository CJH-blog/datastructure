package com.cjh.practice.leetcode;

import java.util.*;

public class LC153 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    static class Solution {
        public int findMin(int[] nums) {
            int left=0, right=nums.length-1;
            int mid = 0;
            int last = nums[nums.length-1];
            while(left<right){
                mid = left + (right-left)/2;
                if(nums[mid]>last) left=mid+1;
                else right=mid;
            }
            return nums[left];
        }
    }

}
