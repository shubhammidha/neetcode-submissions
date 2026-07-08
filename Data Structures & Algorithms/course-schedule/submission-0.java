class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        int indegree[] = new int[numCourses];

        for(int p[]: prerequisites){
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int taken = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            taken++;

            for(int v:graph[u]){
                if(--indegree[v] == 0){
                    q.offer(v);
                }
            }
        }
        return taken == numCourses;
    }
}
