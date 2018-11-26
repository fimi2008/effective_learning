package top.lionxxw.java8;

import java.util.function.Supplier;

/**
 * 方法接口
 * Package top.lionxxw.java8
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/24 11:09
 * version 1.0.0
 */
public class InterfaceExample {

    private interface Defaulable{
        default String noRequired(){
            return "Default implementation";
        }
    }

    private static class DefaultableImple implements Defaulable{
    }

    private static class OverridableImpl implements Defaulable{
        @Override
        public String noRequired() {
            return "Overridden implementation";
        }
    }

    private interface DefaulableFactory {
        // Interfaces now allow static methods
        static Defaulable create( Supplier< Defaulable > supplier ) {
            return supplier.get();
        }
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImple::new);
        System.out.println(defaulable.noRequired());

        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.noRequired());
    }

}
