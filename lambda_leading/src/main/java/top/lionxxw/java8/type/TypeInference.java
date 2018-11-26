package top.lionxxw.java8.type;

/**
 * Package top.lionxxw.java8.type
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/24 14:35
 * version 1.0.0
 */
public class TypeInference {
    public static void main(String[] args){
        final Value<String> value = new Value<>();
        value.getOrDefault("22", Value.defaultValue());
    }
}