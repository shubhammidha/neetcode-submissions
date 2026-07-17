class Solution {
    public List<List<Integer>> combinationSum2(int[] candidate, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidate);

        dfs(0, candidate, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] candidate, int target, List<Integer> curr, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(curr));
        }

        for(int j=i; j<candidate.length; j++){

            //skip duplicates values at adjacents
            if(j > i && candidate[j] == candidate[j - 1]){
                continue;
            }

            if(candidate[j] > target){
                return;
            }

            curr.add(candidate[j]);

            //move to next index
            dfs(j+1, candidate, target - candidate[j], curr, res);

            //backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
