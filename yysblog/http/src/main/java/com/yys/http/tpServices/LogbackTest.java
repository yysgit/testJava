package com.yys.http.tpServices; /**
 * User: 杨永生
 * Date: 9:40 2017/9/5
 * Email: 1095737364@qq.com
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    private final static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        logger.debug("输出debug级别的日志.....");
        logger.info("输出info级别的日志.....");
        logger.error("输出error级别的日志.....");
    }
}
