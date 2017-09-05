package com.yys.common.util;

import java.util.Collection;

/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
public final class StringUtils {
    private StringUtils() {
    }
    public static String join(Object[] array, String sep) {
        return join((Object[])array, sep, (String)null);
    }

    public static String join(Collection list, String sep) {
        return join((Collection)list, sep, (String)null);
    }

    public static String join(Collection list, String sep, String prefix) {
        Object[] array = list == null?null:list.toArray();
        return join(array, sep, prefix);
    }

    public static String join(Object[] array, String sep, String prefix) {
        if(array == null) {
            return "";
        } else {
            int arraySize = array.length;
            if(arraySize == 0) {
                return "";
            } else {
                if(sep == null) {
                    sep = "";
                }

                if(prefix == null) {
                    prefix = "";
                }

                StringBuilder buf = new StringBuilder(prefix);

                for(int i = 0; i < arraySize; ++i) {
                    if(i > 0) {
                        buf.append(sep);
                    }

                    buf.append(array[i] == null?"":array[i]);
                }

                return buf.toString();
            }
        }
    }

    public static String jsonJoin(String[] array) {
        int arraySize = array.length;
        int bufSize = arraySize * (array[0].length() + 3);
        StringBuilder buf = new StringBuilder(bufSize);

        for(int i = 0; i < arraySize; ++i) {
            if(i > 0) {
                buf.append(',');
            }

            buf.append('\"');
            buf.append(array[i]);
            buf.append('\"');
        }

        return buf.toString();
    }

    /**
     * 判断 Object 是否时空
     * @param s
     * @return
     */
    public static boolean isNullOrEmpty(Object s) {
        return org.springframework.util.StringUtils.isEmpty(s);
    }

    /**
     * 判断是否是字符串数组
     * @param s
     * @param array
     * @return
     */
    public static boolean inStringArray(String s, String[] array) {
        String[] var2 = array;
        int var3 = array.length;
        for(int var4 = 0; var4 < var3; ++var4) {
            String x = var2[var4];
            if(x.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
