class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int edge[]: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        int components = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, graph, visited);
                components++;
            }
        }
        return components;
    }

    private void dfs(int u, List<Integer>[] graph, boolean visited[]){
        visited[u] = true;

        for(int v: graph[u]){
            if(!visited[v]){
                dfs(v, graph, visited);
            }
        }
    }
}
