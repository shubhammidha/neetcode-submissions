class Solution {

    int rows, cols;
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];

        for(int c=0; c<cols; c++){
            dfs(0, c, heights, pacific);
            dfs(rows-1, c, heights, atlantic);
        }

        for(int r=0; r<rows;  r++){
            dfs(r, 0, heights, pacific);
            dfs(r, cols-1, heights, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean [][] visited){

        visited[r][c] = true;

        for(int dir[]: directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr<0 || nc<0 || nr>=rows || nc>=cols || visited[nr][nc] || heights[nr][nc] < heights[r][c]){
                continue;
            }
            dfs(nr, nc, heights, visited);
        }
    }
}
