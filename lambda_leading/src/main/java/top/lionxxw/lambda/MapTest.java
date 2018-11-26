package top.lionxxw.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 我们要将costBeforeTax的每个元素以加上他们的增值税。
 * 传递一个Lambda表达式给map方法使之应用于每个元素，之后在用forEach打印结果。
 * Package top.lionxxw.lambda
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 14:42
 * version 1.0.0
 */
public class MapTest {
    public static void main(String[] args) {
        // Without lambda expressions:
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }

        costBeforeTax.stream().map(cost -> .12*cost + cost).forEach(System.out::println);
    }
}
