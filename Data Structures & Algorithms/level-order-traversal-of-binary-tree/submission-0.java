class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();

            for(int i=q.size(); i>0; i--){
                TreeNode a = q.poll();

                if(a != null){
                    level.add(a.val);
                    q.add(a.left);
                    q.add(a.right);
                }
            }
            if(level.size() > 0){
                res.add(level);
            }
        }
        return res;
    }
}
