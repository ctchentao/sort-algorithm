package algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static int partition(int[] data, int start, int end) {
        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (data[index] < data[end]) {
                ++ small;
                if (small != index) {
                    swap(data, small, index);
                }
            }
        }
        ++ small;
        swap(data, small, end);
        return small;
    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void quickSort(int[] data, int start, int end) {
        if (start == end) return;

        int index = partition(data, start , end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

    public static void main(String args[]) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        quickSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
