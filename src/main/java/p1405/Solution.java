package p1405;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        char[] chars = new char[]{'a', 'b', 'c'};
        int[] counts = new int[]{a, b, c};

        StringBuilder sb = new StringBuilder(a + b + c);

        int lastIndex = -1;
        int lastCount = 0;

        while (counts[0] > 0 || counts[1] > 0 || counts[2] > 0) {
            int index = -1;

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0 && (lastIndex != i || lastCount < 2)) {
                    if (index == -1) {
                        index = i;
                    } else if (counts[i] > counts[index]) {
                        index = i;
                    }
                }
            }

            if (index >= 0) {
                if (index == lastIndex) {
                    lastCount++;
                } else {
                    lastCount = 1;
                    lastIndex = index;
                }
                sb.append(chars[index]);
                counts[index]--;
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(1, 1, 7));
    }
}
