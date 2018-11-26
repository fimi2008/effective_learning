package top.lionxxw.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 一个函数reduce可以将所有值转换为一个值。
 * map跟reduce操作是函数式编程的核心，reduce也被称作折叠操作。
 * reduce并不是一种新的操作，在SQL中我们用的一些聚集函数比如sum，avg，count等他们实际上也是reduce操作，
 * 因为他们也是将多个值进行操作然后返回一个值。
 * Stream API定义了reduce函数，可以接受一个Lambda表达式然后组合所有值。]
 * Stream类中像IntStream都有内置的方法像average(), count(), sum(), mapToLong(), mapToDouble()等转换方法。
 * 我们可以用内置的方法也可以自定义。
 * Package top.lionxxw.lambda
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 14:47
 * version 1.0.0
 */
public class ReduceTest {
    public static void main(String[] args) {
        // Old way:
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        // New way:
        Double total2 = costBeforeTax.stream().map(cost -> .12 * cost + cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + total2);
    }

}
