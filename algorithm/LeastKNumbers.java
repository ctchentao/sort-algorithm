package algorithm;

import java.util.Arrays;

public class LeastKNumbers {
    public void adjustHeap(int[] nums, int i, int len) {
        int temp = nums[i];
        for(int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            if (k < len - 1 && nums[k] < nums[k + 1]) {
                ++k;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            }
            else {
                break;
            }
        }
        nums[i] = temp;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] nums = new int[k];
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) return nums;

        for (int i = 0; i < k; ++i) {
            nums[i] = arr[i];
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, k);
        }

        for (int i = k; i < arr.length; ++i) {
            if (nums[0] > arr[i]) {
                nums[0] = arr[i];
                adjustHeap(nums, 0, k);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        int[] nums = new LeastKNumbers().getLeastNumbers(arr, 8);
        System.out.println(Arrays.toString(nums));
    }
}
