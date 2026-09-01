class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length + 1];
        
        // count numbers
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // init frequency list
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = new ArrayList<>();
        }
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            frequency[entry.getValue()].add(entry.getKey());
        }
        
        int[] result = new int[k];
        int index = 0;
        // don't need i = 0
        for (int i = frequency.length - 1; i > 0 && index < k; i--) {
            for (int n : frequency[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
