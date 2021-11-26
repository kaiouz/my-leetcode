package p179;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {

    public String largestNumber(int[] nums) {
        String ans = Arrays.stream(nums).boxed()
                .sorted(new NumComparator().reversed())
                .map(Object::toString)
                .collect(Collectors.joining());
        if (ans.charAt(0) == '0') {
            return "0";
        } else {
            return ans;
        }
    }

    static class NumComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int x1 = 10;
            while (x1 <= o2) {
                x1 *= 10;
            }
            int x2 = 10;
            while (x2 <= o1) {
                x2 *= 10;
            }
            return (o1 * x1 + o2) - (o2 * x2 + o1);
        }

    }
}
