package algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void merger(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (i = 0; i < k; ++i) {
            nums[i + low] = temp[i];
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (high - low) / 2 + low;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merger(nums, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
