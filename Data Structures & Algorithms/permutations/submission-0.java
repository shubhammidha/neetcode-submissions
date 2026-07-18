class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean used[] = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used);    
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> curr, boolean[] used){

        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(used[i]){
                continue;
            }

            used[i] = true;

            curr.add(nums[i]);
            backtrack(nums, curr, used);

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
