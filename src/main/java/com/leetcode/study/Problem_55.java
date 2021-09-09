package com.leetcode.study;

public class Problem_55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution_55().canJump(nums));
    }
}

/**
 * 跳跃游戏
 *
 *  贪心算法
 *      对于数组中任意一个位置 y，只要存在一个位置 x，它本身可以到达，并且它跳跃的最大长度为
 *      x + nums[x]，这个值大于等于 y，即 x + nums[x] >= y，那么位置 y 也可以到达
 *      依次遍历数组中的每一个位置，并实时维护最远可以到达的位置。对于当前遍历到的位置 x，
 *      如果它在最远可以到达的位置的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，
 *      因此我们可以用 x + nums[x] 更新最远可以到达的位置
 *      在遍历的过程中，如果最远可以到达的位置大于等于数组中的最后一个位置，那就说明最后一个位置可达，
 *      我们就可以返回 True 作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案
 */
class Solution_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for(int i=0; i<n; i++){
            if(i <= rightmost){
                rightmost = Math.max(rightmost, i + nums[i]);
                if(rightmost >= n - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
