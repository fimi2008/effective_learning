package top.lionxxw.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题3
 * 编写一个计算前100位斐波那契数的函数。
 * 根据定义，斐波那契序列的前两位数字是0和1，随后的每个数字是前两个数字的和。
 * 例如，前10位斐波那契数为：0，1，1，2，3，5，8，13，21，34。
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.printf("斐波那契序列: %s", fibonacci(100).toString());

    }

    public static  List<Integer> fibonacci(int num) {

        List<Integer> nums = new ArrayList<Integer>();
        if (num > 2){
            nums.add(0);
            nums.add(1);
            int sum = 0;
            while(sum < num){
                sum = nums.get(nums.size() - 1) + nums.get(nums.size() - 2);
                if (sum < num){
                    nums.add(sum);
                }
            }
        }

        return nums;
    }
}
