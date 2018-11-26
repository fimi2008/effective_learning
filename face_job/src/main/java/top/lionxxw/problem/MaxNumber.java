package top.lionxxw.problem;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 问题4
 * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。
 * 例如，给定[50，2，1,9]，最大数字为95021。
 */
public class MaxNumber {
    public static void main(String[] args) {
        Integer[] nums = {50, 2, 1, 9};
        maxNumber(nums);
    }

    public static void maxNumber(Integer[] nums) {
        List<Integer> collect = Arrays.stream(nums).sorted((p1,p2)->{
            int i =String.valueOf(p1).compareTo(String.valueOf(p2));
            return -i;
        }).collect(toList());
        System.out.println(collect);

        StringBuffer sb = new StringBuffer();
        collect.forEach(sb::append);
        System.out.println(sb);
    }
}
