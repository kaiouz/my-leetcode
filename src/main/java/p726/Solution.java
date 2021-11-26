package p726;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        LinkedList<Integer> stack = new LinkedList<>();

        int weight = 1;
        int i = formula.length() - 1;
        int count = 1;

        while (i >= 0) {
            if (formula.charAt(i) == ')') {
                weight *= count;
                stack.push(count);
                count = 1;
                i--;
            } else if (formula.charAt(i) == '(') {
                weight /= stack.pop();
                i--;
            } else if (Character.isDigit(formula.charAt(i))) {
                int r = i;
                while (Character.isDigit(formula.charAt(i))) {
                    i--;
                }
                count = Integer.parseInt(formula.substring(i + 1, r + 1));
            } else {
                int r = i;
                while (Character.isLowerCase(formula.charAt(i))) {
                    i--;
                }
                String automic = formula.substring(i, r + 1);
                Integer autoCount = map.getOrDefault(automic, 0);
                map.put(automic, autoCount + count * weight);
                count = 1;
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countOfAtoms("K4(ON(SO3)2)2"));
    }
}
