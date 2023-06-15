package core.java.practice.leet.code;

public class TowSortedArrayMedian {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //swap no if alws first should be small
        if(nums1.length > nums2.length){
            int[] temp =  nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        //find out pointers for first array and second array
        int totalLen   = nums1.length + nums2.length;
        int firstIndex  =  0 ;
        int lastIndex  =  totalLen -2  ;
        while(firstIndex < lastIndex){
        }
        return 0.0;
    }

    public void swapBasedOnSmallFirst(int[] nums1, int[] nums2){
        int[] temp =  nums1;
        nums1 = nums2;
        nums2 = temp;
    }

    public boolean isEven(int no){
        return no%2==0;
    }
}
