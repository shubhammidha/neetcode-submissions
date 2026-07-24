class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int first[] = java.util.Arrays.copyOf(nums, nums.length - 1);
        int second[] = java.util.Arrays.copyOfRange(nums, 1, nums.length);

        return(Math.max(robbb(first), robbb(second)));
    }

    private int robbb(int[] nums){
        if (nums.length == 1) return nums[0];
        
        int top = 0;

        for(int i = nums.length - 2; i >= 0; i--){
            int next = (i + 2 < nums.length) ? nums[i + 2] : top;
            nums[i] = Math.max(nums[i] + next, nums[i + 1]);
        }
        return nums[0];
    }
}
