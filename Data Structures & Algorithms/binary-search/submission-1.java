class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) { // нужно чтобы элемент не пропустить
        
            /*тоже самое что и (left+right)/2, но защищает от переполнения засчет
            смены порядка операций*/
            int middle = (left + ((right - left)) / 2);  
            
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {  // мы справа отностельно target
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return -1;
    }
}
