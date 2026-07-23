class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = 0; // Represents the appended 0

        for (int i = cost.length - 2; i >= 0; i--) {
            int next2 = (i + 2 < cost.length) ? cost[i + 2] : top;
            cost[i] += Math.min(cost[i + 1], next2);
        }

        return Math.min(cost[0], cost[1]);
    }
}