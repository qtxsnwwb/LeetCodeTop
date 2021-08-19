package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_862 {
    public static void main(String[] args) {
        int[] nums = {2,-1,2};
        int k = 3;
        System.out.println(new Solution_862().shortestSubarray(nums, k));
    }
}

/**
 * 和至少为 K 的最短子数组
 *
 *  滑动窗口
 */
class Solution_862 {
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        long[] P = new long[N+1];
        for(int i=0; i<N; i++)
            P[i+1] = P[i] + (long)nums[i];

        int ans = N + 1;
        Deque<Integer> monoq = new LinkedList<>();

        for(int y=0; y<P.length; y++){
            while(!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while(!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + k)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N + 1 ? ans : -1;
    }
}
