package core.java.practice.leet.code2;

public class SearchInRotatedArray {
    public int search(int[] nums, int target){
        int length = nums.length;
        int result = -1;
        int i = 0 , j = length-1, mid;
        while (i< j){
            mid =  (length -1) /2 ;
            if(nums[i] == target) return i;
            else if(nums[j] == target) return j;
            else if(nums[mid] == target) return mid;
            //check right side is sorted
            if(nums[mid] >= nums[i]){
                if(nums[i]< target && target < nums[mid]){
                    j = mid-1;
                }else {
                    i = mid+1;
                }
            }else if(nums[j] >= nums[mid]){
                if(nums[mid] < target && target < nums[j]){
                    i = mid+1;
                }else {
                    j = mid-1;
                }
            }
        }


        return result;
    }


}
