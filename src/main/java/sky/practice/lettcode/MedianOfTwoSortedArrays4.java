package sky.practice.lettcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author fei
 */
public class MedianOfTwoSortedArrays4 {
    /**
     * 基本上是归并排序的思路
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        int total = len1 + len2;
        int mediaInt = total / 2;
        int[] mediaIndexes;
        double sum = 0;
        if (total % 2 == 1) {
            mediaIndexes = new int[]{mediaInt};
        } else {
            mediaIndexes = new int[]{mediaInt - 1, mediaInt};
        }
        if (len1 == 0) {
            return getMedia(nums2, mediaIndexes);
        }
        if (len2 == 0) {
            return getMedia(nums1, mediaIndexes);
        }
        int[] big = null;
        int[] small = null;
        if (nums1[0] > nums2[len2 - 1]) {
            big = nums1;
            small = nums2;
        } else if (nums2[0] > nums1[len1 - 1]) {
            big = nums2;
            small = nums1;
        }

        if (big != null) {
            for (int i : mediaIndexes) {
                sum += get(small, big, i);
            }
            return sum / mediaIndexes.length;
        }
        int[] mergerArray = new int[total];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 >= len1) {//nums1 done
                System.arraycopy(nums2, index2, mergerArray, index, total - index);
                break;
            }
            if (index2 >= len2) {//nums2 done
                System.arraycopy(nums1, index1, mergerArray, index, total - index);
                break;
            }

            if (nums1[index1] <= nums2[index2]) {
                mergerArray[index] = nums1[index1];
                index1++;
            } else {
                mergerArray[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        return getMedia(mergerArray, mediaIndexes);
    }

    public static double getMedia(int[] nums, int[] medias) {
        double sum = 0;
        for (int i : medias) {
            sum += nums[i];
        }
        return sum / medias.length;
    }

    public static int get(int[] nums1, int[] nums2, int index) {
        if (nums1.length - 1 >= index) {
            return nums1[index];
        } else {
            return nums2[index - nums1.length];
        }
    }
}
