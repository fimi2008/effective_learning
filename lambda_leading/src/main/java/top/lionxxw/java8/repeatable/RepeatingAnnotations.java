package top.lionxxw.java8.repeatable;

import java.lang.annotation.*;

/**
 * 重复注解
 * Package top.lionxxw.java8.repeatable
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/24 13:50
 * version 1.0.0
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {
    }

    /**
     * 这里有个使用@Repeatable( Filters.class )注解的注解类Filter，
     * Filters仅仅是Filter注解的数组，但Java编译器并不想让程序员意识到Filters的存在。
     * 这样，接口Filterable就拥有了两次Filter（并没有提到Filter）注解。
     *
     * @param args
     */
    public static void main(String[] args) {
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}