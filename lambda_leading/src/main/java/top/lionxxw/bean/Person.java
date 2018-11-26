package top.lionxxw.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Package top.lionxxw.bean
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/1 15:14
 * version 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {
    private String firstName, lastName, job, gender;
    private int age,salary;
}
