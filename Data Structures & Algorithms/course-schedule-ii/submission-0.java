class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        int indegree[] = new int[numCourses];

        for(int pre[]: prerequisites){
            graph[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int order[] = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            order[idx++] = curr;

            for(int u: graph[curr]){
                if(--indegree[u] == 0){
                    q.offer(u);
                }
            }
        }
        return idx == numCourses? order: new int[0];
    }
}
