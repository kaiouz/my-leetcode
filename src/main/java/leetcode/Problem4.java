package leetcode;

public class Problem4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 偶数有2个,奇数只有1个
        int[] idxs;
        if (((nums1.length + nums2.length) & 1) == 0) {
            idxs = new int[]{(nums1.length + nums2.length) / 2, (nums1.length + nums2.length) / 2 + 1};
        } else {
            idxs = new int[]{(nums1.length + nums2.length) / 2 + 1};
        }
        int count = idxs.length;
        int[] median = new int[count];
        int p = 0, q = 0;
        int c = 0;
        int i = 0;

        while (p < nums1.length && q < nums2.length) {
            int num;
            if (nums1[p] < nums2[q]) {
                num = nums1[p];
                p++;
            } else {
                num = nums2[q];
                q++;
            }
            i++;
            if (i == idxs[c]) {
                median[c] = num;
                c++;
                if (--count == 0) {
                    break;
                }
            }
        }

        if (count != 0) {
            int t;
            int[] nums3;
            if (p < nums1.length) {
                t = p;
                nums3 = nums1;
            } else {
                t = q;
                nums3 = nums2;
            }
            while (t < nums3.length) {
                int num = nums3[t];
                t++;
                i++;
                if (i == idxs[c]) {
                    median[c] = num;
                    c++;
                    if (--count == 0) {
                        break;
                    }
                }
            }
        }

        if (median.length == 1) {
            return median[0];
        } else {
            return (median[0] + median[1]) / 2.0;
        }
    }


    public static void main(String[] args) {
        new Problem4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }

}
