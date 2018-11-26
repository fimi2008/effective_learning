package top.lionxxw.java8.parameter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Package top.lionxxw.java8.parameter
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/24 14:57
 * version 1.0.0
 */
public class ParameterNames {
    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
    }
}
