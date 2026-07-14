class Solution {


    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket: tickets){
            graph.putIfAbsent(ticket.get(0),new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK");

        Collections.reverse(ans);

        return ans;
    }

    private void dfs(String airport){
        PriorityQueue<String> neighbor = graph.get(airport);

        while(neighbor != null && !neighbor.isEmpty()){
            String nei = neighbor.poll();

            dfs(nei);
        }
        ans.add(airport);
    }
}
