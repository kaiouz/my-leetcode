package p227;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

class Solution {

    Map<Character, Op> ops = new HashMap<>();

    public Solution() {
        ops.put('+', new Op(1, (a, b) -> a + b));
        ops.put('-', new Op(1, (a, b) -> b - a));
        ops.put('*', new Op(2, (a, b) -> a * b));
        ops.put('/', new Op(2, (a, b) -> b / a));
    }

    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Op> sign = new LinkedList<>();

        int i = 0;


        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int n = c - '0';
                while (++i < s.length() && Character.isDigit(i)) {
                    c = s.charAt(i);
                    n = (c - '0') + n * 10;
                }
                stack.offerLast(n);
            } else if (c != ' ') {
                Op op = ops.get(c);
                while (!sign.isEmpty() && sign.peekLast().pri > op.pri) {
                    stack.offerLast(sign.pollLast().apply(stack.pollLast(), stack.pollLast()));
                }
                sign.offerLast(op);
                i++;
            }
        }

        int ans = stack.pollLast();

        while (!sign.isEmpty()) {
            ans = sign.pollLast().apply(ans, stack.pollLast());
        }

        return ans;
    }


    static class Op implements BiFunction<Integer, Integer, Integer> {

        int pri;

        BiFunction<Integer, Integer, Integer> fun;

        public Op(int pri, BiFunction<Integer, Integer, Integer> fun) {
            this.pri = pri;
            this.fun = fun;
        }

        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return fun.apply(integer, integer2);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3/2"));
    }

}
