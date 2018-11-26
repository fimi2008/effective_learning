package top.lionxxw.builder;

import top.lionxxw.bean.Person;
import top.lionxxw.bean.Woman;

/**
 * Package top.lionxxw.builder
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 17:09
 * version 1.0.0
 */
public class WoManBuilder implements PersonBuilder {

    private Person person;

    public WoManBuilder() {
        this.person = new Woman();
    }

    @Override
    public void buildHead() {
        person.setHead("建造女人的头");
    }

    @Override
    public void buildBody() {
        person.setHead("建造女人的身体");
    }

    @Override
    public void buildFoot() {
        person.setHead("建造女人的脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
