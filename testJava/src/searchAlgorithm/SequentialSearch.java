package searchAlgorithm;

/**
 * User: 杨永生
 * Date: 16:55 2017/8/29
 * Email: kevin@hiibook.com
 */
public class SequentialSearch {
    public static int SequenceSearch(int a[], int value) {
        int i;
        for (i = 0; i < a.length; i++)
            if (a[i] == value)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 197, 76, 213, 27, 50};
        int num = SequenceSearch(a, 213);
        System.out.println("数组的下标是:" + num);
    }
}
