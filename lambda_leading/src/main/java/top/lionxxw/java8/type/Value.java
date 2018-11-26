package top.lionxxw.java8.type;

/**
 * Package top.lionxxw.java8.type
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/24 14:34
 * version 1.0.0
 */
public class Value<T> {
    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }
}
