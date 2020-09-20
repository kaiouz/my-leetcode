package ms1618;

class Solution {
    public boolean patternMatching(String pattern, String value) {
        return match(pattern, 0, value, 0, -1, 0, -1, 0);
    }

    private boolean match(String p, int pi, String s, int si, int aStart, int aLen, int bStart, int bLen) {
        if (pi >= p.length()) {
            if (si >= s.length()) {
                return true;
            } else {
                return false;
            }
        }

        char c = p.charAt(pi);
        int cStart, cLen;

        if (c == 'a') {
            cStart = aStart;
            cLen = aLen;
        } else {
            cStart = bStart;
            cLen = bLen;
        }

        // 已匹配过，比较
        if (cStart >= 0) {
            if (eq(s, si, cStart, cLen)) {
                if (c == 'a') {
                    return match(p, pi + 1, s, si + cLen, cStart, cLen, bStart, bLen);
                } else {
                    return match(p, pi + 1, s, si + cLen, aStart, aLen, cStart, cLen);
                }
            } else {
                return false;
            }
        } else {
            // 没有匹配过，逐个尝试
            for (cStart = si, cLen = 0; cLen <= s.length() - cStart; cLen++) {
                boolean isMatch;
                if (c == 'a') {
                    if (cLen == bLen && eq(s, bStart, cStart, cLen)) {
                        continue;
                    }
                    isMatch = match(p, pi + 1, s, si + cLen, cStart, cLen, bStart, bLen);
                } else {
                    if (cLen == aLen && eq(s, aStart, cStart, cLen)) {
                        continue;
                    }
                    isMatch = match(p, pi + 1, s, si + cLen, aStart, aLen, cStart, cLen);
                }
                if (isMatch) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean eq(String s, int si, int cStart, int cLen) {
        if (si < 0) {
            return false;
        }
        if (si + cLen > s.length()) {
            return false;
        }
        for (int i = 0; i < cLen; i++) {
            if (s.charAt(cStart + i) != s.charAt(si + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().patternMatching("abba", "dogdogdogdog"));
    }
}
