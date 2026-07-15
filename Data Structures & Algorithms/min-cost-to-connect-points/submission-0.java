class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean visited[] = new boolean[n];

        minHeap.offer(new int[]{0, 0});

        int totalCost = 0;
        int visitedCount = 0;

        while(visitedCount < n){
            int curr[] = minHeap.poll();
            int cost = curr[0];
            int point = curr[1];

            if(visited[point]){
                continue;
            }

            visited[point] = true;
            totalCost += cost;
            visitedCount++;

            for(int next=0; next < n; next++){
                if(!visited[next]){
                    int distance = Math.abs(points[point][0] - points[next][0]) + Math.abs(points[point][1] - points[next][1]);
                    minHeap.offer(new int[]{distance, next});
                }
            }
        }
        return totalCost;
    }
}
