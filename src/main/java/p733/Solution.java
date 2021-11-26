package p733;

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        int cur = image[sr][sc];
        image[sr][sc] = -1;

        if (sr >= 1 && image[sr - 1][sc] == cur) {
            dfs(image, sr - 1, sc, newColor);
        }

        if (sr + 1 < image.length && image[sr + 1][sc] == cur) {
            dfs(image, sr + 1, sc, newColor);
        }

        if (sc >= 1 && image[sr][sc - 1] == cur) {
            dfs(image, sr, sc - 1, newColor);
        }

        if (sc +1 < image[sr].length && image[sr][sc + 1] == cur) {
            dfs(image, sr, sc + 1, newColor);
        }

        image[sr][sc] = newColor;
    }
}
