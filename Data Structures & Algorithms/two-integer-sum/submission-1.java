class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> previousNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (previousNums.containsKey(complement)) {
                return new int[]{previousNums.get(complement), i};
            }
            previousNums.put(nums[i], i);
        }
        return new int[0];
    }
}
