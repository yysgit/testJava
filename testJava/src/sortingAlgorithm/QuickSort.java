package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 10:36 2017/8/29
 * Email: kevin@hiibook.com
 */
public class QuickSort {
    public static void subSort(int[] source, int begin, int end) {
        if (begin < end) {
            // 标记1从开始起,因为不包括base，而且使用前要++,所以为这个数
            int sign1 = begin;
            // 标记2从结束起，使用前要--,所以为这个数
            int sign2 = end + 1;
            // 假设第一个为base
            int base = source[begin];
            while (true) {
                // 从左向右找第一个比base大的数，用sign1标记索引
                while (source[++sign1] < base && sign1 < end) {}
                // 从右到左找第一个比base小的数，用sign2标记索引
                while (source[--sign2] > base && sign2 > begin) {}
                // 若此时sign1和sign2没有碰头，就交换它们
                if (sign1 < sign2) {
                    int temp = source[sign1];
                    source[sign1] = source[sign2];
                    source[sign2] = temp;
                    // 若已经碰头，就结束循环
                } else {
                    break;
                }
            }
            //将base和sign2换一下，这样，已经将原数组分成2部分，中间的那个为base
            int temp = source[begin];
            source[begin] = source[sign2];
            source[sign2] = temp;
            subSort(source, begin, sign2 - 1);
            subSort(source, sign2 + 1, end);
        }
    }
    public static void main(String[] args) {
        int[] array = { 83, 7, 11, 47, 66, 26, 85, 79, 44, 14};
        System.out.print("排序前:\t");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
        subSort(array,0, array.length - 1);
        System.out.print("排序后:\t");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }
}
