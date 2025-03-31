package com.ezcatcat.oj.homeworkHelp0327;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://www.baidu.com?id=123&age=18 id
 * 对url解析，存到map，再根据参数获取value
 * @Author: EzCatcat
 * @Date: 2025/3/27 20:25
 */
public class No1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        String url = split[0];
        String param = split[1];
        Map<String, String> map = new HashMap<>();
        int idx = url.indexOf("?");
        int n = url.length();
        String substring = url.substring(idx + 1, n);
        String[] params = substring.split("&");
        for (String p : params) {
            String[] kv = p.split("=");
            map.put(kv[0], kv[1]);
        }
        System.out.println(map.get(param));
    }
}
