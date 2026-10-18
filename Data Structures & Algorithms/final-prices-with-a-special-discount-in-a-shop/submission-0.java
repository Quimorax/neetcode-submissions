class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> indexesStack = new ArrayDeque<>();
        int[] result = prices.clone();

        for (int i = 0; i < prices.length; i++) {
            while (!indexesStack.isEmpty() && prices[i] <= prices[indexesStack.peek()]) {
                int prevIndex = indexesStack.pop();
                result[prevIndex] -= prices[i];
            }
            indexesStack.push(i);
        }
        return result;
    }
}
