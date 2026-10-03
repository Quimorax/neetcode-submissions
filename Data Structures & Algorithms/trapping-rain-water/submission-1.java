class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int[] leftMax = findLeftMaxArray(height);
        int[] rightMax = findRightMaxArray(height);

        int result = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int waterAmount = Math.min(leftMax[i - 1], rightMax[i + 1]) - height[i];
            if (waterAmount > 0) result += waterAmount;
        }

        return result;
    }

    private int[] findLeftMaxArray(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        return leftMax;
    }

    private int[] findRightMaxArray(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        return rightMax;
    }
}
