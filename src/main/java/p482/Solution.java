package p482;

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                count++;
            }
        }

        if (count == 0) {
            return "";
        }

        int first = count % k;
        int segs = count / k;
        if (first == 0) {
            first = k;
            segs--;
        }

        int total = count + segs;
        StringBuilder sb = new StringBuilder(total);
        int i = 0;
        int n = 0;

        while (n < first) {
            char c = s.charAt(i++);
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
                n++;
            }
        }

        while (i < s.length() && sb.length() < total) {
            sb.append('-');
            n = 0;
            while (n < k) {
                char c = s.charAt(i++);
                if (c != '-') {
                    sb.append(Character.toUpperCase(c));
                    n++;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("---", 3));
    }
}
