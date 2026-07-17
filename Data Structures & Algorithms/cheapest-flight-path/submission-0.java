class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int flight[]: flights){
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        minHeap.offer(new int[]{0, src, 0}); // cost, city, stops

        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);

        while(!minHeap.isEmpty()){
            int curr[] = minHeap.poll();

            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if(stops > k+1){
                continue;
            }

            if(city == dst){
                return cost;
            }

            if(stops > bestStops[city]){
                continue;
            }

            bestStops[city] = stops;

            for(int nei[]: graph[city]){
                minHeap.offer(new int[]{cost + nei[1], nei[0], stops + 1});
            }
        }
        return -1;
    }
}