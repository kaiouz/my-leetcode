package ms1005;

class Solution {

    public int findString(String[] words, String s) {
        int l = 0;
        int r = words.length;

        int mid = l;
        while (l < r) {
            mid = (l + r) / 2;

            if (words[mid].length() == 0) {
                int temp = mid - 1;
                while (temp >= l && words[temp].length() == 0) {
                    temp--;
                }
                if (temp < l) {
                    temp = mid + 1;
                    while (temp < r && words[temp].length() == 0) {
                        temp++;
                    }
                    if (temp >= r) {
                        break;
                    }
                }
                mid = temp;
            }

            int ret = s.compareTo(words[mid]);
            if (ret < 0) {
                r = mid;
            } else if (ret > 0) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


}
