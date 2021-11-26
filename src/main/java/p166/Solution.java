package p166;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        long num = 0;
        long denom = 0;

        if (numerator < 0 && denominator < 0) {
            num = -((long) numerator);
            denom = -((long)denominator);
        } else if (numerator < 0) {
            num = -((long) numerator);
            denom  = denominator;
            ans.append('-');
        } else if (denominator < 0) {
            num = numerator;
            denom = -((long)denominator);
            ans.append('-');
        } else {
            num = numerator;
            denom  = denominator;
        }

        ans.append(num / denom);

        long remainder = num % denom;

        if (remainder > 0) {
            ans.append('.');

            StringBuilder sb = new StringBuilder();
            Map<Long, Integer> set = new HashMap<>();
            Integer repeat = null;

            int i = 0;
            while (remainder != 0) {
                if (set.containsKey(remainder)) {
                    repeat = set.get(remainder);
                    break;
                } else {
                    set.put(remainder, i++);
                    remainder *= 10;
                    sb.append(remainder / denom);
                    remainder %= denom;
                }
            }

            if (repeat != null) {
                ans.append(sb, 0, repeat);
                ans.append('(');
                ans.append(sb, repeat, sb.length());
                ans.append(')');
            } else {
                ans.append(sb);
            }
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(-50,
                8));
    }
}
