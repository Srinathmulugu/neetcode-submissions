class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty() && fresh > 0) {
            int n = q.size();
            for (int k = 0; k < n; k++) {
                int[] curr = q.remove();
                int i = curr[0];
                int j = curr[1];

                for (int[] d : dir) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                        || grid[r][c] != 1) {
                        continue;
                    }

                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[] {r, c});
                }
            }
            count++;
        }
        return fresh == 0 ? count : -1;
    }
}
