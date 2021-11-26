package p1711;

import java.util.Arrays;

class Solution {

    public int countPairs(int[] deliciousness) {
        Arrays.sort(deliciousness);
        int ans = 0;
        int target = 1;
        for (int i = 0; i < 21; i++) {
            target <<= 1;
            ans = (ans + countPairs(deliciousness, target)) % 1000000007;
        }
        return ans;
    }

    private int countPairs(int[] deliciousness, int target) {
        int l = 0;
        int r = deliciousness.length -1;
        int count = 0;
        while (l < r) {
            int cur = deliciousness[l] + deliciousness[r];
            if (cur > target) {
               do {
                   r--;
               } while (r > l && deliciousness[r] == deliciousness[r+1]);
            } else if (cur < target) {
                do {
                    l++;
                } while(l < r && deliciousness[l] == deliciousness[l-1]);
            } else {
                if (deliciousness[l] == deliciousness[r]) {
                    count += (r - l + 1) * (r - l) / 2;
                    break;
                }
                int lc = 0;
                int rc = 0;
                do {
                   r--;
                   rc++;
                } while (r >= 0 && deliciousness[r] == deliciousness[r+1]);
               do {
                    l++;
                    lc++;
                } while(l < deliciousness.length && deliciousness[l] == deliciousness[l-1]);
                count += lc * rc;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[] {1,1,1,3,3,3,7}));
    }
}
