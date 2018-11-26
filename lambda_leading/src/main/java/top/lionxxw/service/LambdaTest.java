package top.lionxxw.service;


/**
 * Package top.lionxxw.service
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 9:22
 * version 1.0.0
 */
public class LambdaTest {
    public void eat(Eatable eatable) {
        System.out.println(eatable);
        eatable.taste();
    }

    public void drive(Flyable flyable) {
        System.out.println("Driving...");
        flyable.fly("===Sunny Day===");
    }

    public void sum(Addable addable) {
        int a = 2;
        int b = 3;
        System.out.println(a + " + " + b + " = " + addable.add(a, b));
    }

    public static void main(String[] args) {
        LambdaTest t = new LambdaTest();
        t.eat(() -> System.out.println("the car is delicious"));
        t.drive((weather) -> System.out.println("this weather is" + weather));
        t.sum((a, b) -> a + b);

        //强制类型转换为函数式接口
        Object obj = (Runnable)()->{
            for (int i = 0; i < 10; i++){
                System.out.println(i);
            }
        };
    }
}
