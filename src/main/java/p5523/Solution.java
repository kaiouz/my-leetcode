package p5523;

class Solution {
    public int minOperations(String[] logs) {
        int s = 0;

        for (String log : logs) {
            if ("../".equals(log)) {
                if (s > 0) {
                    s--;
                }
            } else if ("./".equals(log)) {

            } else {
                s++;
            }
        }

        return s;
    }
}
