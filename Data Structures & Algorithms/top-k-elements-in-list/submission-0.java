class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for(int i=0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(int n: nums){
            if(count.containsKey(n)){
                count.put(n, count.get(n) + 1);
            }
            else{
                count.put(n, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int res[] = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i>0 && index < k; i--){
            for(int n: freq[i]){
                res[index] = n;
                index ++;

                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
