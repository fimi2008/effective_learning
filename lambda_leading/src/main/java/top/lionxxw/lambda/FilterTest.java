package top.lionxxw.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用filter创建一个字符串List
 * 在java开发中对大的集合进行过滤是常用的操作。
 * 用Lambda表达式和Stream API会让操作变得简单易懂。
 * Stream提供了一个filter()方法，接受一个Predicate对象。
 * 这意味着可以传递一个Lambda表达式作为过滤逻辑
 * Package top.lionxxw.lambda
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 15:07
 * version 1.0.0
 */
public class FilterTest {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("xx", "aa", "bb", "cc", "ddc");
        //创建一个长度大于两个字符的字符串List
        List<String> filtered = strList.stream()
                .filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

        //将字符串转为大写然后用逗号连起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy","U.K.","Canada");
        String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        //复制不同值到子列表 本例演示如何利用Stream类的distinct方法过滤重复值到集合中。
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);

    }
}
