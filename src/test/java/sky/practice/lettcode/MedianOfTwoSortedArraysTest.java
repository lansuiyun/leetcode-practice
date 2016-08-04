package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void testFindMedianSortedArrays() throws Exception {
        int[] nums1 = new int[0];
        int[] nums2 = new int[]{2,3};

        assertTrue(MedianOfTwoSortedArrays4.findMedianSortedArrays(nums1, nums2) == 2.0);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};

        assertTrue(MedianOfTwoSortedArrays4.findMedianSortedArrays(nums1, nums2) == 2.5);
    }

    @Test
    public void testGet() throws Exception {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{5, 6, 7};
        assertEquals(MedianOfTwoSortedArrays4.get(nums1, nums2, 3), 5);
        assertEquals(MedianOfTwoSortedArrays4.get(nums1, nums2, 1), 2);
    }
}