package p1574;

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr[before]) {
                before = i;
            } else {
                break;
            }
        }

        if (before == arr.length - 1) {
            return 0;
        }

        int after = arr.length - 1;
        for (int i = arr.length - 1; i > before; i--) {
            if (arr[i] <= arr[after]) {
                after = i;
            } else {
                break;
            }
        }

        int diff = after - before - 1;

        if (arr[after] >= arr[before]) {
            return diff;
        }

        int ans = Integer.MAX_VALUE;
        int j = after;

        for (int i = 0; i <= before; i++) {
            if (arr[i] > arr[j]) {
                ans = Math.min(ans, before - i + 1 + j - after);
                while (j < arr.length && arr[j] < arr[i]) {
                    j++;
                }
                if (j < arr.length && arr[j] < arr[before]) {
                    ans = Math.min(ans, before - i + j - after);
                } else {
                    ans = Math.min(ans, j - after);
                    break;
                }
            }
        }

        return ans + diff;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[] {
                5002,5282, 4699,7983,8340
        }));
    }
}
