package com.cjh.practice.leetcode;

import java.util.*;

public class LC4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        HashMap<Integer, Integer> m = new HashMap<>();
        m.merge(1,1, (k,v)->(v+1));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }


    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length>nums2.length){
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }
            int m=nums1.length, n=nums2.length;
            int leftCount = (m+n+1)/2;
            int left=0, right=m;
            while(left<right){
                int i = left+(right-left+1)/2;
                int j = leftCount-i;
                if(nums1[i-1]>nums2[j]){
                    right=i-1;
                }else{
                    left=i;
                }
            }
            int i = left;
            int j = leftCount-i;
            int nums1LeftMax = i==0?Integer.MIN_VALUE:nums1[i-1];
            int nums1RightMin = i==m?Integer.MAX_VALUE:nums1[i];
            int nums2LeftMax = j==0?Integer.MIN_VALUE:nums2[j-1];
            int nums2RightMin = j==n?Integer.MAX_VALUE:nums2[j];

            int leftMax = Integer.max(nums1LeftMax, nums2LeftMax);
            int rightMin = Integer.min(nums1RightMin, nums2RightMin);
            if((m+n)%2==1){
                return leftMax;
            }else{
                return (double)(leftMax+rightMin)/2;
            }
        }
    }

}
