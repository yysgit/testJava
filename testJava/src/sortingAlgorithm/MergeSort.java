package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 11:29 2017/8/29
 * Email: kevin@hiibook.com
 */
public class MergeSort {
    public static void merge(int[] arr, int first, int mid, int last, int[] sorted) {
        int i = first, j = mid;
        int k = 0;
        while (i < mid && j < last)
            if (arr[i] < arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        while (i < mid)
            sorted[k++] = arr[i++];
        while (j < last)
            sorted[k++] = arr[j++];

        for (int v = 0; v < k; v++)
            arr[first + v] = sorted[v];
    }

    public static void merge_sort(int[] unsorted, int first, int last, int[] sorted) {
        if (first+1 < last) {
            int mid = (first + last) / 2;
            merge_sort(unsorted, first, mid, sorted);//左边有序
            merge_sort(unsorted, mid, last, sorted);//右边有序
            merge(unsorted, first, mid, last, sorted);//两个数值合并
        }
    }
    public static void main(String[] args) {
        int[] array = {6, 2, 4, 1, 5, 9};//原始数组
        int[] sorted = new int[array.length];//新建数组,排序后的数值
        merge_sort(array, 0, array.length, sorted);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}
