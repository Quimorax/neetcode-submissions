class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                // Есть точка разрыва в правой части (значит и минимум)
                left = middle + 1;
            } else {
                // Правая часть отсортирована, минимум в middle или слева
                right = middle;
            }
        }

        return nums[left];  // момент когда left=right, нашли минимум
    }
}
