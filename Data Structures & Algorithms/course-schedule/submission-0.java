class Solution {
    public boolean canFinish(int num, int[][] pre) {
        int[] indeg = new int[num];
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] in : pre) {
            int u = in[0];
            int v = in[1];
            adj.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if ( indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            count++;
            for (int next : adj.get(curr)) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.add(next);
                }
            }
        }
        return count == num;
    }
}
