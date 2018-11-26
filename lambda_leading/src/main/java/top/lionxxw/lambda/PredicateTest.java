package top.lionxxw.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 使用Lambda表达式和函数式接口Predicate
 * 除了提供函数式编程语言级别的支持外，java8同时也新增了一个新的包java.util.function。
 * 其中包含了许多类来支持java函数式编程。
 * 其中之一是Predicate接口，使用这个接口和lamb表达式就可以以更少的代码为API方法添加更多的动态行为。
 * 以下是Predicate的使用范例，展示了过滤集合数据的许多共性。
 * Package top.lionxxw.lambda
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 14:17
 * version 1.0.0
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));
        System.out.println("Print all languages :");
        filter(languages, (str) -> true);
        System.out.println("Print no language : ");
        filter(languages, (str) -> false);
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        /**
         * Predicate允许组合两个以上的条件，它提供了类似于逻辑与和或的操作and(),or()，这些方法可以用来组合传递到filter方法中的多个条件。
         */
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream().filter(startsWithJ.and(fourLetterLong)).forEach((n) -> System.out.print("\nName, which starts with 'J' and four letter long is : " + n));
    }

    public static void filter(List<String> names, Predicate<String> condition) {
       /* names.forEach(name -> {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        });*/

        names.stream().filter(condition::test).forEach(name -> System.out.println(name + " "));
    }
}
