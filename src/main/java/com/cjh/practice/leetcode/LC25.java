package com.cjh.practice.leetcode;

public class LC25 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

   // key point: find the first node of next segment
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode cur = head;
            int count = 0;
            while(cur != null && count != k){
                count++;
                cur = cur.next;
            }
            if(count == k){
                cur = reverseKGroup(cur, k);
                while(count-->0){
                    ListNode tmp = head.next;
                    head.next = cur;
                    cur = head;
                    head = tmp;
                }
                head = cur;
            }
            return head;

        }
    }

}
