package top.lionxxw.Item5;


import java.util.Date;

/**
 * 变量sum被声明成Long而不是long，意味着程序构造了大约2的31次方个多余的Long实例
 * 结论：要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱
 */
public class Sum {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) {
        Date start = new Date();
        System.out.printf("start %s", start);
        Long sum = 0L;
//        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        Date end = new Date();
        System.out.printf("end %s 本次运行消耗时间： %s", end, end.getTime()-start.getTime());
    }
}
