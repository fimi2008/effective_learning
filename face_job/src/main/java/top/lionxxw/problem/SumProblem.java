package top.lionxxw.problem;

/**
 * 问题1
 * 使用for循环、while循环和递归写出3个函数来计算给定数列的总和。
 */
public class SumProblem {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.printf("for 计算结果为：%s", sum);
        System.out.println();

        sum = 0;
        int index = 0;
        while (nums.length > index) {
            sum = sum + nums[index++];
        }
        System.out.printf("while 计算结果为：%s", sum);

        System.out.println();
        System.out.printf("递归 计算结果为：%s", sumNums(nums, 0));
    }

    public static int sumNums(int[] nums, int index) {
        int sum = 0;
        sum = sum + nums[index++];
        if (index < nums.length){
            sum = sum +sumNums(nums, index);
        }
        return sum;
    }
}
