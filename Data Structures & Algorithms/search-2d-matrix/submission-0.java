class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l = 0;
        int r = ROWS * COLS -1;

        while(l <= r){
            int m = l + (r - l) / 2;
            int rows = m / COLS;
            int cols = m % COLS;

            if(target < matrix[rows][cols]){
                r = m - 1;
            }
            else if(target > matrix[rows][cols]){
                l = m + 1;
            }
            else{
                return true;
            }
        } 
        return false;
    }
}
