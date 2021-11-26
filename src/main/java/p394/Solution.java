package p394;

class Solution {

    private int i = 0;

    public String decodeString(String s) {
        return dfs(s).toString();
    }

    private StringBuilder dfs(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                i++;
                StringBuilder ssb = dfs(s);
                for (int k = 0; k < count; k++) {
                    sb.append(ssb);
                }
                count = 0;
            } else if (c == ']') {
                break;
            }
            i++;
        }

        return sb;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }

}
