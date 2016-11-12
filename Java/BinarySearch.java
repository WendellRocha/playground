import java.util.*;

class BinarySearch {

    public static int busca(int[] nums, int left, int right, int n) {
        if (left > right)
            return -1;
        else {
            int mid = (left + right) / 2;
            if (nums[mid] == n)
                return mid;
            else if (n < nums[mid])
                return busca(nums,left,mid-1,n);
            else
                return busca(nums,mid+1,right,n);
        }


    }

}
