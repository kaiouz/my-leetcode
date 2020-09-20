package p125;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);

            boolean leftOk = Character.isLetterOrDigit(leftC);
            boolean rightOk = Character.isLetterOrDigit(rightC);

            if (leftOk && rightOk) {
                if (Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) {
                    return false;
                }

                left++;
                right--;
                continue;
            }

            if (!leftOk) {
                left++;
            }

            if (!rightOk) {
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("0P"));
    }

}
