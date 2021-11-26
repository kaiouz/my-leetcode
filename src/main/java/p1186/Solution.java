package p1186;

class Solution {
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int del = 0;
        int notDel = arr[0];
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int curNotDel = Math.max(arr[i], notDel + arr[i]);
            int curDel = Math.max(arr[i] + del, notDel);
            ans = Math.max(ans, Math.max(curNotDel, curDel));
            del = curDel;
            notDel = curNotDel;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maximumSum(new int[]{-1, -1, -1, -1}));
    }
}
