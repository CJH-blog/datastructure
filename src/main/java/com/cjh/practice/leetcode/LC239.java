package com.cjh.practice.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC239 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(Solution.maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    static class Solution {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];

            // 块内前缀最大值
            for (int i = 0; i < n; i++) {
                if (i % k == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = Math.max(left[i - 1], nums[i]);
                }
            }

            // 块内后缀最大值
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1 || (i + 1) % k == 0) {
                    right[i] = nums[i];
                } else {
                    right[i] = Math.max(nums[i], right[i + 1]);
                }
            }

            int[] ans = new int[n - k + 1];

            for (int l = 0; l <= n - k; l++) {
                int r = l + k - 1;
                ans[l] = Math.max(right[l], left[r]);
            }

            return ans;
        }
        public static int[] maxSlidingWindow2(int[] nums, int k){
            Deque<Integer> dq = new LinkedList<>();
            int[] res = new int[nums.length-k+1];
            for (int i = 0; i < nums.length; i++) {
                while(!dq.isEmpty() && nums[dq.peekFirst()]<nums[i]){
                    dq.pollFirst();
                }
                dq.offer(i);
                if(i>=k-1){
                    res[i-k+1] = nums[dq.peekFirst()];
                }
            }
            return res;
        }
    }

}
