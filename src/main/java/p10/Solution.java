package p10;

class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 要考虑s,p的推倒过程中空的情况,
        // 比如: s="", p="a*",
        // 所以这个矩阵的大小是(m+1)*(n+1)不是m*n
        // 定义: sub(s, i)=s.subString(0, i)与sub(p, j)=p.subString(0, j),
        // f[i][j]的含义是s.subString(0, i)与p.subString(0, j)是否匹配
        boolean[][] f = new boolean[m + 1][n + 1];

        // sub(s, 0)和sub(p, 0)都为空, 两者是匹配的
        f[0][0] = true;

        for (int i = 0; i <= m; i++) {
            // p是空，s不是空，肯定是false的，所以j从1开始
            for (int j = 1; j <= n; j++) {
                // sub(p, j)的最后一个字符索引是j-1, j是长度
                if (p.charAt(j - 1) == '*') {
                    // 这里*是不会出现在第一个字符的
                    f[i][j] = f[i][j - 2];
                    if (match(s, p, i, j-1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                }
            }
        }

        return f[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        // 调用这个方法时，j>0，也就是p不是空的，s要是空的,那肯定是false了
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return p.charAt(j - 1) == s.charAt(i - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a", ".*..a*"));
    }
}
