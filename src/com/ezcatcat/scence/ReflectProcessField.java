package com.ezcatcat.scence;

import java.lang.reflect.Field;

/**
 * 判断对象的属性是不是boolean，对象的名字是不是is开头
 * @Author: EzCatcat
 * @Date: 2025/4/3 22:41
 */
public class ReflectProcessField {
    public static void main(String[] args) {
        TestObj0403 testObj1 = new TestObj0403(true, true);
        // 1. 反射获取对象属性
        Field[] fields = testObj1.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == boolean.class) {
                System.out.println("对象属性是boolean：" + field.getName());
            }
            if (field.getName().startsWith("is")) {
                System.out.println("对象属性是is开头：" + field.getName());
            }
        }
        System.out.println("=====================");
        // 2. 判断对象名字是不是is开头，不能，只能获取属性的

    }
}
class TestObj0403 {
    public TestObj0403(boolean isTest, boolean test) {
        this.isTest = isTest;
        this.test = test;
    }

    private boolean isTest;
    private boolean test;
}