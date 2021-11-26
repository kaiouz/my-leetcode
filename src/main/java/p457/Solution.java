package p457;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int[] status = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (status[i] == 0) {
                if (dfs(status, nums, i)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(int[] status, int[] nums, int cur) {
        int next = (cur + nums[cur]) % nums.length;
        if (next < 0) {
            next += nums.length;
        }
        if (cur != next
                && ((nums[next] > 0 && nums[cur] > 0) || (nums[next] < 0 && nums[cur] < 0))) {
            if (status[next] == 0) {
                status[cur] = 1;
                if (dfs(status, nums, next)) {
                    return true;
                } else {
                    status[cur] = 2;
                    return false;
                }
            } else {
                status[cur] = status[next];
                return status[cur] == 1;
            }
        } else {
            status[cur] = 2;
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().circularArrayLoop(new int[] {-2, -3, -9}));
    }
}
