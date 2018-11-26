package top.lionxxw.builder;

import top.lionxxw.bean.Person;

/**
 * Package top.lionxxw.builder
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 17:12
 * version 1.0.0
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}
