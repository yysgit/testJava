package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 18:08 2017/8/28
 * Email: kevin@hiibook.com
 */
public class SimpleSelectionSort {
    /**
     * 简单选择排序
     * 原理：从i到arr.length-1，每次迭代将i到arr.length-1中最小（最大）的那个数交换到i的位置，然后i++，再循环
     * @param arr 待排序的数组
     */
    public static void simpleSelectSort(int[] arr){
        //minLoc用于记录i+1到arr.length-1这个区间的最小值的下标（i会递增），i表示要交换的位置。
        for (int i=0,j=0,minLoc=0; i<arr.length; i++) {
            minLoc = i;
            for (j=i+1; j < arr.length; j++) {//找出i+1到args.length-1这个区间的最小值的下标
                if(arr[j] < arr[minLoc]){
                    //记录最小值下标
                    minLoc = j;
                }
            }
            if(minLoc!=i){//如果minLoc!=i，说明minLoc有变化，就进行交换
                int temp = arr[i];
                arr[i] = arr[minLoc];
                arr[minLoc] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {12,53,48,26,43,62,46,48};
        System.out.print("before sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        simpleSelectSort(array);
        System.out.print("after  sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
