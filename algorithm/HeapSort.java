package algorithm;

import java.util.Arrays;

public class HeapSort {
    public static void adjustHeap (int[] nums, int i, int len) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            if (k < len - 1 && nums[k] < nums[k + 1]) {
                ++k;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; --i) {
            adjustHeap(nums, i, len);
        }

        for (int j = len - 1; j > 0; --j) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
    }
    private static void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        //int []arr = {7,6,7,11,5,12,3,0,1};
        int []arr = {0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};

        heapSort(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }
}
