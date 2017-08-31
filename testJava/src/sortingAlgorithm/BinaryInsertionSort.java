package sortingAlgorithm;

/**
 * User: 杨永生
 * Date: 13:43 2017/8/28
 * Email: kevin@hiibook.com
 */
public class BinaryInsertionSort {
    public static void biInsertSort(int arr[]){
        for(int i = 1; i < arr.length; i ++){
            int temp = arr[i];
            int left = 0;
            int right = i-1;
            while(left <= right){//通过拆装查找找到插入位置
                int mid = (left+right)/2;
                if(temp < arr[mid]){//插入点在[left,mid-1]
                    right = mid-1;
                }else               //插入点在[mid+1,right]
                    left = mid+1;
            }//直到找到合适的位置（left或right+1），接下来就将left/right+1后的元素后移
            for(int j = i-1;j >= right+1; j --){
                arr[j+1] = arr[j];
            }
            arr[right+1] = temp;
        }
    }
    public static void main(String[] args) {
        int array[] = {2,5,3,1,5,2,8};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }
        biInsertSort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}
