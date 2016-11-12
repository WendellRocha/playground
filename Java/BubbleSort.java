import java.util.*;

class BubbleSort {

    public void bubble(int[] nums) {
        
        boolean trocou;
        
        for (int i = 0; i < nums.length; i++) {
            trocou = false;
            for (int j = 0; i < nums.length - j - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int aux = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = aux;
                    trocou = true;
                }
            }

            if (!trocou)
                return;
        }
    }
}
