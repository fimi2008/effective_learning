package top.lionxxw.java8.bean;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用
 * Package top.lionxxw.java8.bean
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/24 13:34
 * version 1.0.0
 */
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        List<Car> cars = Collections.singletonList(car);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
