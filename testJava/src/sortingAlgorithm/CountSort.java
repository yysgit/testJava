package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 14:10 2017/8/29
 * Email: kevin@hiibook.com
 */
public class CountSort {
    private static int[] countSort(int[] array, int k) {
        //建立两个数组:B数组和C数组
        int[] C = new int[k + 1];//构造C数组
        int length = array.length, sum = 0;//获取A数组大小用于构造B数组
        int[] B = new int[length];//构造B数组

        // 统计A中各元素个数，存入C数组
        for (int i = 0; i < length; i++) {
            C[array[i]] += 1;
        }
        //累积每个元素的个数:建立C数组的值
        for (int i = 0; i < k + 1; i++) {
            sum += C[i];
            C[i] = sum;
        }
        //遍历A数组，构造B数组
        for (int i = length - 1; i >= 0; i--) {
            B[C[array[i]] - 1] = array[i];//将A中该元素放到排序后数组B中指定的位置
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素:相同的元素依次排在后面
        }
        return B;//将排序好的数组返回，完成排序

    }
    public static void main(String[] args) {
        int[] A = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = countSort(A, 5);
        for (int num : B) {
            System.out.print(num+" ");
        }
    }
}
