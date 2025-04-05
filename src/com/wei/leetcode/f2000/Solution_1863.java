package com.wei.leetcode.f2000;

class Solution_1863 {

    public static void main(String[] args) {
        Solution_1863 solution = new Solution_1863();
        int res = solution.subsetXORSum(new int[]{2, 5, 6});
        System.out.println("res = " + res);
    }

    /*
    作者：力扣官方题解
    链接：https://leetcode.cn/problems/stone-game-vii/solutions/2626699/shi-zi-you-xi-vii-by-leetcode-solution-8wqc/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int n : nums) {
            or |= n;
        }
        return or << (nums.length - 1);
    }
}

