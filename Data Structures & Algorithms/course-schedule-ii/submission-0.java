class Solution {
    public int[] findOrder(int num, int[][] pre) {
        int[] indeg = new int[num];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : pre) {
            int u = edge[0];
            int v = edge[1];
            list.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);
            for (int next : list.get(curr)) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.add(next);
                }
            }
        }
        int[] res = new int[num];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        if (num == ans.size()) {
            return res;
        }

        return new int[0];
    }
}
