class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int edge[]: edges){
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }

        boolean visited[] = new boolean[n];
        dfs(0, -1, graph, visited);

        for(boolean v: visited){
            if(!v){
                return false;
            }
        }
        return true;
    }

    private void dfs(int node, int parent, List<Integer>[] graph, boolean visited[]){
        visited[node] = true;

        for(int n: graph[node]){
            if(n == parent){
                continue;
            }
            if(!visited[n]){
                dfs(n, node, graph, visited);
            }
        }
    }
}
