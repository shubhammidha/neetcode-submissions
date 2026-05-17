class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int lMax[] = new int[n];
        lMax[0] = height[0];

        for(int i=1; i<n; i++){
            lMax[i] = Math.max(height[i], lMax[i-1]);
        }

        int rMax[] = new int[n];
        rMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--){
            rMax[i] = Math.max(height[i], rMax[i+1]);
        }

        int trappedWater = 0;
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(lMax[i], rMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}
