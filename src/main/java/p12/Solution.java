package p12;

class Solution {

    private char[][] ch = new char[][] {
        {'I', 'V', 'I', 'X'},
        {'X', 'L', 'X', 'C'},
        {'C', 'D', 'C', 'M'},
        {'M', ' ', ' ', ' '}
    };

    private int[][] counts = new int[][] {
        {0, 0, 0, 0},
        {1, 0, 0, 0},
        {2, 0, 0, 0},
        {3, 0, 0, 0},
        {1, 1, 0, 0},
        {0, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 1, 2, 0},
        {0, 1, 3, 0},
        {0, 0, 1, 1}
    };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int w = 0;

        while (num != 0) {
            int n = num % 10;

            for (int i = counts[n].length -1; i >= 0 ; i--) {
                for (int c = 0; c < counts[n][i]; c++) {
                    sb.append(ch[w][i]);
                }
            }

            w++;
            num /= 10;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1994));
    }
}
