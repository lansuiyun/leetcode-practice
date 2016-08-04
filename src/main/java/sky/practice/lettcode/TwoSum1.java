package sky.practice.lettcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * <a href="https://leetcode.com/problems/two-sum/">地址</a>
 *
 * @author fei
 */
public class TwoSum1 {
    /**
     * 给定int数组nums，int target，寻找int数组indexes，使得nums[indexes[0]] + nums[indexes[1]] == target
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length, 1);
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < 0 || nums[i] > target) {
//                continue;
//            }
            Integer other = map.get(target - nums[i]);
            if (other != null) {
                indexes[0] = i;
                indexes[1] = other;
                return indexes;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
