package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 16:27 2017/8/28
 * Email: kevin@hiibook.com
 */
public class ShellSort {
    /**
     * 对希尔排序中的单个组进行排序
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组总的长度
     * i -- 组的起始位置
     * gap -- 组的步长
     * <p>
     * 组是"从i开始，将相隔gap长度的数都取出"所组成的！
     */
    public static void groupSort(int[] a, int n, int i, int gap) {
        //打印分组
        System.out.print("gap="+gap+" [");
        //打印第一个比较的元素
        System.out.print(a[i]);
        //直接插入排序
        for (int j = i + gap; j < n; j += gap) {
            //被比较的元素
            System.out.print(" "+a[j]);
            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (a[j] < a[j - gap]) {
                int tmp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > tmp) {
                    a[k + gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = tmp;
//                System.out.print(" ("+a[j]+"<-->"+a[j-gap]+")");
            }
        }
        System.out.println("]");
    }
    /**
     * 希尔排序
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组的长度
     */
    public static void shellSort(int[] a, int n) {
        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++)
                groupSort(a, n, i, gap);
            System.out.printf("after sort:");
            for (int i = 0; i < a.length; i++)
                System.out.printf("%d ", a[i]);
            System.out.println();
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int i;
        int a[] = {80, 30, 60, 40, 20, 10, 50, 70,100};
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.println();
        System.out.println();
        shellSort(a, a.length);
    }

}
