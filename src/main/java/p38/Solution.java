package p38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder prev = new StringBuilder("1");
        StringBuilder cur = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            int count = 1;
            char ch = prev.charAt(0);

            for (int j = 1; j < prev.length(); j++) {
                char c = prev.charAt(j);
                if (c == ch) {
                    count++;
                } else {
                    cur.append(count).append(ch);
                    count = 1;
                    ch = c;
                }
            }

            cur.append(count).append(ch);

            prev = cur;
            cur = new StringBuilder(prev.length() * 2);
        }

        return prev.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(30));
    }
}
