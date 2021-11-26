package p5546;

class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int pre = 0;
        int maxDuration = 0;
        char maxKey = '0';

        for (int i = 0; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - pre;
            pre = releaseTimes[i];
            if (duration > maxDuration) {
                maxDuration = duration;
                maxKey = keysPressed.charAt(i);
            } else if (duration == maxDuration) {
                if (keysPressed.charAt(i) > maxKey) {
                    maxKey = keysPressed.charAt(i);
                }
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().slowestKey(new int[] {12,23,36,46,62}, "spuda"));
    }
}
