class Solution {
    public int maxArea(int[] heights) {
        ArrayList<Integer> height = new ArrayList<>();

        for(int h: heights){
            height.add(h);
        }

        int maxWater = 0;
        int start = 0;
        int end = heights.length - 1;

        while(start < end){
            int ht = Math.min(height.get(start), height.get(end));
            int width = end - start;
            int currWater = ht * width;

            maxWater = Math.max(currWater, maxWater);

            if(height.get(start) > height.get(end)){
                end--;
            }
            else{
                start++;
            }
        }
        return maxWater;
    }
}
