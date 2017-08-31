package sort;

/**
 * User: 杨永生
 * Date: 10:11 2017/8/9
 * Email: kevin@hiibook.com
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {

    List list  =   new  LinkedList();
    public   static   void  main(String[] args)  {
        List list  =   new  LinkedList();
        for  ( int  i  =   0 ; i  <   9 ; i ++ )  {
            list.add(i);
        }
        System.out.println(list);

        Collections.sort(list); // 顺序排列
        System.out.println(list);

        Collections.shuffle(list); // 混乱的意思
        System.out.println(list);

        Collections.reverse(list); // 倒序排列
        System.out.println(list);

        System.out.println(Collections.binarySearch(list,  5 )); // 折半查找
    }

}