package p5473;

class Solution {
    public int minFlips(String target) {
        int len = target.length();
        char cur = target.charAt(len - 1);
        int times = 0;

        for (int i = len - 2; i >= 0; --i) {
            if (target.charAt(i) != cur) {
                times++;
                cur = target.charAt(i);
            }
        }

        return cur == '0' ? times : times + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minFlips("101"));
    }
}
