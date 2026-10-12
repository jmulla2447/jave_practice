package core.java.practice.idnow;

/*
*  we have sorted array but we have reapeated no like 1 1 2 2 3 3 3 3 4 4   target  3 result we need to retun taget 1st and last index liek (4, 8)
* if not present than -1 -1
* */
public class Exam {

    public static int[] findRange(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
        }
        for (int i = 0, j = len - 1; i <= j; ) {
            if (nums[i] != target) {
                i++;
                continue;
            }

            if (nums[j] != target) {
                j--;
                continue;
            }
            result[0] = i;
            result[1] = j;
            break;
        }
        return result;

    }

    /*why this logic is not working becuase we breaking down array and create a new one using arraycopy
    insade fo this we need to preserve the original array adn then binarySearch finution pass
            orginal array , start and end postion along with target and result */
    public static void binarySearch(int[] nums, int start, int end, int target, int[] result, DIRECTION direction) {
        if(start==end ) {
            if (nums[start] == target) {
                if (direction == DIRECTION.RIGHT) {
                    result[0] = start;
                } else if (direction == DIRECTION.LEFT) {
                    result[1] = start;
                }
            }
            return;
        }

        int mid = (start+end) / 2;

        if (nums[mid] == target) {

            if(result[0] == -1  &&  result[1] == -1) {
                result[0] = mid;
                result[1] = mid;
            }
            binarySearch(nums, 0, mid, target, result, DIRECTION.RIGHT);
            binarySearch(nums, mid+1, end, target, result, DIRECTION.LEFT);
        } else if (nums[mid] > target) {
            binarySearch(nums, 0, mid, target, result, DIRECTION.RIGHT);
        } else if (nums[mid] < target) {
            binarySearch(nums, mid+1, end, target, result,DIRECTION.LEFT);
        }
    }




    enum DIRECTION{ LEFT, RIGHT}

    public static void main(String[] args) {// 334
        int[] i = {1, 3, 3, 3, 3, 3, 5, 6, 9};//1,3,       3,3
        //3,3        ,5,6

        var result = findRange(i, 2);


        int[] result1 = new int[2];
        result[0] = -1;
        result[1] = -1;
        binarySearch(i, 0, i.length-1, 3, result1, DIRECTION.RIGHT);
        System.out.println(result1[0]);
        System.out.println(result1[1]);

    }

}


