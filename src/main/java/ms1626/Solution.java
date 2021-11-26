package ms1626;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

class Solution {

    public int calculate(String s) {
        Map<Character, Operator> operatorMap = new HashMap<>();
        operatorMap.put('+', new Operator(0, Integer::sum));
        operatorMap.put('-', new Operator(0, (a, b) -> b - a));
        operatorMap.put('*', new Operator(1, (a, b) -> a * b));
        operatorMap.put('/', new Operator(1, (a, b) -> b / a));

        LinkedList<Operator> operater = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();

        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                int n = c - '0';
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i++) - '0';
                }
                nums.push(n);
            } else if (c != ' '){
                Operator curOp = operatorMap.get(c);
                while (!operater.isEmpty() && curOp.order <= operater.peek().order) {
                    Operator op = operater.poll();
                    nums.push(op.op.apply(nums.poll(), nums.poll()));
                }
                operater.push(curOp);
            }
        }

        while (!operater.isEmpty()) {
            Operator op = operater.poll();
            nums.push(op.op.apply(nums.poll(), nums.poll()));
        }

        return nums.poll();
    }

    static class Operator {
        int order;
        BiFunction<Integer, Integer, Integer> op;

        public Operator(int order, BiFunction<Integer, Integer, Integer> op) {
            this.order = order;
            this.op = op;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1-1+1"));
    }
}
