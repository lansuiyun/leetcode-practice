package sky.practice.lettcode;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class TwoSum1Test {

    @org.junit.Test
    public void testTwoSum() throws Exception {
        int[] nums = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int target = 10;

        int[] indexes = TwoSum1.twoSum(nums, target);
        assertNotNull(indexes);
        assertEquals(indexes.length, 2);
        assertTrue(nums[indexes[0]] >= 0);
        assertTrue(nums[indexes[1]] >= 0);
        assertEquals(nums[indexes[0]] + nums[indexes[1]], target);
    }

    @org.junit.Test
    public void testTwoSum2() throws Exception {
        int[] nums = new int[]{5,6,5,7};
        int target = 10;

        int[] indexes = TwoSum1.twoSum(nums, target);
        assertNotNull(indexes);
        assertEquals(indexes.length, 2);
        assertTrue(nums[indexes[0]] >= 0);
        assertTrue(nums[indexes[1]] >= 0);
        assertEquals(nums[indexes[0]] + nums[indexes[1]], target);
    }
}