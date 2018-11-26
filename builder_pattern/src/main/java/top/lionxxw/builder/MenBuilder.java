package top.lionxxw.builder;

import top.lionxxw.bean.Men;
import top.lionxxw.bean.Person;

/**
 * Package top.lionxxw.builder
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 17:09
 * version 1.0.0
 */
public class MenBuilder implements PersonBuilder {

    private Person person;

    public MenBuilder() {
        this.person = new Men();
    }

    @Override
    public void buildHead() {
        person.setHead("建造男人的头");
    }

    @Override
    public void buildBody() {
        person.setHead("建造男人的身体");
    }

    @Override
    public void buildFoot() {
        person.setHead("建造男人的脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
