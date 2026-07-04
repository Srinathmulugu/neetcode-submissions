class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
       dist[k] = 0;
       for(int i = 1; i < n; i++){
           
           for(int[] edge: times){
               int u = edge[0];
               int v = edge[1];
               int w = edge[2];

               if(dist[u] != INF && dist[u] + w < dist[v]){
                   dist[v] = dist[u] + w;
               }
           }
           
       }
       int ans = 0;
       for(int i=1; i <= n; i++){

          if(dist[i] == INF){
             return -1;
          }   
          ans = Math.max(ans, dist[i]);
     
       }
       return ans;
        
    }
}
