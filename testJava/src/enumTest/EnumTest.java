package enumTest;

import enumTest.Color;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by hiibook on 2017/3/15.
 */
public class EnumTest {
    public enum Size{ SMALL, MEDIUM, LARGE, EXTRA_LARGE };//常量枚举
    public static void main(String[] args) {
        System.out.println(Size.SMALL);
        System.out.println(Color.BLANK);
        System.out.println(Color.getColorByIndex(1));
        System.out.println(Color.getColorByName("白色"));
        System.out.println(Color.getIndexByName("白色"));
        System.out.println(Color.getNameByIndex(1));
        // EnumSet的使用
        EnumSet<Color> weekSet = EnumSet.allOf(Color.class);
        for (Color color : weekSet) {
            System.out.println(color);
        }
        // EnumMap的使用
        EnumMap<Color, String> weekMap = new EnumMap(Color.class);
        weekMap.put(Color.GREEN, "绿");
        weekMap.put(Color.BLANK, "白");
        for (Iterator<Map.Entry<Color, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Map.Entry<Color, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
    }
}
