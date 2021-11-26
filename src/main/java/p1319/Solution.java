package p1319;

class Solution {

    public int makeConnected(int n, int[][] connections) {
        more = 0;
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        return more >= --count ? count : -1;
    }


    private int more;
    private int count;
    private int[] parent;

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            more++;
        } else {
            parent[px] = py;
            count--;
        }
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
