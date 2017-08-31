package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 13:09 2017/8/28
 * Email: kevin@hiibook.com
 */
public class StraightInsertionSort {
    public static void insertsort(int arr[]){
        for(int i = 1;i < arr.length; i ++){
            if(arr[i] < arr[i-1]){//注意[0,i-1]都是有序的。如果待插入元素比arr[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
                int temp = arr[i];
                int j;
                for(j = i-1; j >= 0 && arr[j] > temp; j --){
                    arr[j+1] = arr[j];//把比temp大或相等的元素全部往后移动一个位置
                }
                arr[j+1] = temp;//把待排序的元素temp插入腾出位置的(j+1)
            }
        }
    }
    public static void main(String[] args) {
        int array[] = {4,2,1,5};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }
        insertsort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}
