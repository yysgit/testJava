package com.yys.common.util;

import org.apache.commons.io.Charsets;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
public class DigestUtils extends org.springframework.util.DigestUtils {

    public static String md5Hex(final String data) {
        return DigestUtils.md5DigestAsHex(data.getBytes(Charsets.UTF_8));
    }

    public static String md5Hex(final byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }
}
