class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbersCount = new HashMap<>();
        for (int num : nums) {
            numbersCount.put(num, numbersCount.getOrDefault(num, 0) + 1);
        }

        return numbersCount.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}