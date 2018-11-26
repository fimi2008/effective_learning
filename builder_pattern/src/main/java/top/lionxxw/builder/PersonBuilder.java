package top.lionxxw.builder;

import top.lionxxw.bean.Person;

/**
 * 角色构造
 * Package top.lionxxw.builder
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 17:06
 * version 1.0.0
 */
public interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();
}
