package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 10:06 2017/8/29
 * Email: kevin@hiibook.com
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print("第" + i + "趟:\t");
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 2, 4, 1, 5, 9};
        System.out.print("排序前:\t");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
        bubbleSort(array);
        System.out.print("排序后:\t");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }

}
