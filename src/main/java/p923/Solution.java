package p923;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long ans = 0;
        long mod = 1_000_000_007;

        int[] counts = new int[101];
        for (int n : arr) {
            counts[n]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }

            int j = i + 1;
            int k = counts.length - 1;

            if (i >= target) {
                break;
            }

            int tt = target - i;

            if (tt - i > i && counts[i] >= 2) {
                ans += (counts[i] - 1) * (counts[i] - 1) * counts[tt - i];
            }

            while (j <= k) {
                if (counts[j] == 0) {
                    j++;
                    continue;
                }
                if (counts[k] == 0) {
                    k--;
                    continue;
                }
                int sum = j + k;
                if (sum == tt) {
                    if (j == k && counts[j] >= 2) {
                        ans += counts[i] * (counts[j] - 1) * (counts[j] - 1);
                    } else {
                        ans += counts[i] * counts[j] * counts[k];
                    }
                    j++;
                    k--;
                } else if (sum > tt) {
                    k--;
                } else {
                    j++;
                }
            }

        }

        return (int) (ans%mod);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5},
        8));
    }
}
