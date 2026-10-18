public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        Map<Integer, Integer> indexes = new HashMap<>();
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            indexes.put(nums1[i], i);
            result[i] = -1;
        }

        for (int i = 0; i < nums2.length; i++) {
            int value = nums2[i];
            while (!monotonicStack.isEmpty() && value > monotonicStack.peek()) {
                int last = monotonicStack.pop();
                
                if (indexes.containsKey(last)) {
                    result[indexes.get(last)] = value;
                }
            }
            monotonicStack.push(value);
        }
        return result;
    }
}