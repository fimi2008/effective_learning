package top.lionxxw.java8.parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 并行（parallel）数组
 * Package top.lionxxw.java8.parallel
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/25 16:26
 * version 1.0.0
 */
public class ParallelExample {
    /**
     * Java 8增加了大量的新方法来对数组进行并行处理。可以说，最重要的是parallelSort()方法，因为它可以在多核机器上极大提高数组排序的速度
     * @param args
     */
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
    }
}
