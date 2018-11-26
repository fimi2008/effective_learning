package top.lionxxw;

import top.lionxxw.bean.Person;
import top.lionxxw.builder.MenBuilder;
import top.lionxxw.builder.PersonDirector;
import top.lionxxw.builder.WoManBuilder;

/**
 * Package top.lionxxw
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/3 17:15
 * version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Person womanPerson = pd.constructPerson(new MenBuilder());
        Person manPerson = pd.constructPerson(new WoManBuilder());
    }
}
