class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> withoutDuplicates = new HashSet<>();
        
        for (int num : nums) {
            if (!withoutDuplicates.add(num)) {
                return true;
            }
        }
        return false;
    }
}