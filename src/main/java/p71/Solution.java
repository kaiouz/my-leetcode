package p71;

import java.nio.file.Paths;

class Solution {
    public String simplifyPath(String path) {
        char[] ans = new char[path.length()];
        ans[0] = '/';
        int p = 0;

        int l = 1;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                p = append(ans, p, path, l, i);
                l = i+1;
            }
        }

        p = append(ans, p, path, l, path.length());

        if (p == 0) {
            ans[p++] = '/';
        }

        return new String(ans, 0, p);
    }

    private int append(char[]ans, int p, String path,  int l, int i) {
        int typ = type(path, l, i);
        if (typ == 3) {
            ans[p++] = '/';
            while (l < i) {
                ans[p++] = path.charAt(l++);
            }
        } else if (typ == 2) {
            if (p > 0) {
                do {
                    p--;
                } while (p > 0 && ans[p] != '/');
            }
        }
        return p;
    }

    private int type(String path, int l, int r) {
        int len = r - l;
        if (len == 1) {
            return path.charAt(l) == '.' ? 1 : 3;
        } else if (len == 2) {
            return path.charAt(l) == '.' && path.charAt(l+1) == '.' ? 2 : 3;
        } else if (len == 0) {
            return 0;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Paths.get("/home//foo/").toAbsolutePath().toString());
    }
}
