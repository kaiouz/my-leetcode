package p93;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<String> ans = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return Collections.emptyList();
        }
        dfs(new char[s.length() + 3], 0, s, 0, 3);
        return ans;
    }

    private void dfs(char[] ip, int next, String s, int si, int dot) {
        if (next == ip.length) {
            if (isValid(ip)) {
                ans.add(new String(ip));
            }
            return;
        }

        if (dot > 0) {
            ip[next] = '.';
            dfs(ip, next + 1, s, si, dot - 1);
        }

        if (si < s.length()) {
            ip[next] = s.charAt(si);
            dfs(ip, next + 1, s, si + 1, dot);
        }
    }

    private boolean isValid(char[] ip) {
        boolean prevNum = false;
        int curNum = 0;
        boolean prevZero = false;
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] == '.') {
                if (!prevNum) {
                    return false;
                }
                prevNum = false;
                prevZero = false;
                curNum = 0;
            } else {
                if (prevZero) {
                    return false;
                }
                prevZero = !prevNum && ip[i] == '0';
                curNum = curNum * 10 + (ip[i] - '0');
                if (curNum > 255) {
                    return false;
                }
                prevNum = true;
            }
        }
        return prevNum;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}
