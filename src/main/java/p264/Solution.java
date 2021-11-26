package p264;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 5) {
            return n;
        }

        List<Boolean> list = new ArrayList<>(3000);
        list.add(false);
        list.add(true);
        list.add(true);
        list.add(true);
        list.add(true);
        list.add(true);

        int num = 5;
        int i = 5;

        while(num != n) {
            i++;
            if (i % 2 == 0) {
                list.add(list.get(i/2));
            } else if (i % 3 == 0) {
                list.add(list.get(i/3));
            } else if (i % 5 == 0) {
                list.add(list.get(i/5));
            } else {
                list.add(Boolean.FALSE);
            }
            if (list.get(i)) {
                num++;
            }
        }

        return i;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
