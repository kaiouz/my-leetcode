package p1328;

class Solution {

    public String breakPalindrome(String palindrome) {
        int half = palindrome.length() / 2;

        for (int i = 0; i < half; i++) {
            if (palindrome.charAt(i) > 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }

        if (palindrome.length() > 1) {
            return palindrome.substring(0, palindrome.length()-1) + (char)(palindrome.charAt(palindrome.length()-1) + 1);
        }

        return "";
    }

}
