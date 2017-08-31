package searchAlgorithm;

/**
 * User: 杨永生
 * Date: 17:20 2017/8/29
 * Email: kevin@hiibook.com
 */
public class InterpolationSearch {
    public static int insertionSearch(int a[], int value, int low, int high) {
        int mid = low + (value - a[low]) / (a[high] - a[low]) * (high - low);
        if (a[mid] == value)
            return mid;
        if (a[mid] > value)
            return insertionSearch(a, value, low, mid - 1);
        if (a[mid] < value)
            return insertionSearch(a, value, mid + 1, high);
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {27,38,49,50,65,76,197,213};//必须是有序的
        int num = insertionSearch(a, 213,0,a.length-1);
        System.out.println("数组的下标是:" + num);
    }
}
