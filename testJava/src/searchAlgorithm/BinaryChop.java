package searchAlgorithm;

/**
 * User: 杨永生
 * Date: 17:07 2017/8/29
 * Email: kevin@hiibook.com
 */
public class BinaryChop {
    //二分查找（折半查找）
    public static int binarySearch1(int a[], int value) {
        int low, high, mid;
        low = 0;
        high = a.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == value)
                return mid;
            if (a[mid] > value)
                high = mid - 1;
            if (a[mid] < value)
                low = mid + 1;
        }
        return -1;
    }

    //二分查找，递归版本:low 表示开始下标,high 表示最后的下标
    public static int binarySearch2(int a[], int value, int low, int high) {
        int mid = low + (high - low) / 2;
        if (a[mid] == value)
            return mid;
        if (a[mid] > value)
            return binarySearch2(a, value, low, mid - 1);
        if (a[mid] < value)
            return binarySearch2(a, value, mid + 1, high);
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 197, 76, 213, 27, 50};
        int num1 = binarySearch1(a, 213);
        int num2 = binarySearch2(a, 213,0,a.length-1);
        System.out.println("数组的下标是:" + num1);
        System.out.println("数组的下标是:" + num2);
    }
}
