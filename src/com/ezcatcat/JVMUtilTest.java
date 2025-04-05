package com.ezcatcat;

/**
 * jconsole连接失败，在vm options添加：-Djava.rmi.server.hostname=127.0.0.1 -Dcom.sun.management.jmxremote.port=8888 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dspring.profiles.active=ci
 * 使用远程连接
 * @Author: EzCatcat
 * @Date: 2025/4/5 20:26
 */
public class JVMUtilTest {
    public static void main(String[] args) throws InterruptedException {
        // 死循环，持续消耗CPU
        while (true) {
            Thread.sleep(100);
            System.out.println("123");
        }
    }
}
