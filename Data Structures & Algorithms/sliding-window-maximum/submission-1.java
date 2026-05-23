class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int [nums.length - k + 1];

        int idx = 0;

        for(int r=0; r<nums.length; r++){

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.pollLast();
            }

            dq.offerLast(r);

            if(dq.peekFirst() < (r - k + 1)){
                dq.pollFirst();
            }
            if(r >= k-1){
                res[idx++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
