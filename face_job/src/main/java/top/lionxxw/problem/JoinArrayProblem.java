package top.lionxxw.problem;

import java.util.Arrays;

/**
 * 问题2
 * 编写一个交错合并列表元素的函数。例如：给定的两个列表为[a，B，C]和[1，2，3]，函数返回[a，1，B，2，C，3]。
 */
public class JoinArrayProblem {

    public static void main(String[] args) {
        String[] strArray = {"a","B","C"};
        Integer[] nums = {1,2,3};
        System.out.printf("交错合并列表元素:%s", Arrays.toString(join(strArray, nums)));
    }

    public static Object[] join(Object[] obj1, Object[] obj2){
        int max = obj1.length > obj2.length? obj1.length:obj2.length;
        Object[] arr = new Object[obj1.length+obj2.length];
        int index = 0;
        for (int i = 0; i < max; i++) {
            if (i < obj1.length){
                arr[index++] = obj1[i];
            }
            if (i < obj2.length){
                arr[index++] = obj2[i];
            }
        }
        return arr;
    }
}
