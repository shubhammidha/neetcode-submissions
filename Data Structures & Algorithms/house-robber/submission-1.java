class Solution {
    public int rob(int[] nums) {
        int top = 0;

        for(int i = nums.length - 2; i >= 0; i--){
            int next = (i + 2 < nums.length) ? nums[i + 2] : top;
            nums[i] = Math.max(nums[i] + next, nums[i + 1]);
        }
        return nums[0];
    }
}
