package top.lionxxw.item1;// Simple test program for service provider framework

/**
 * 第一条：考虑用静态工厂方法代替构造器
 * 优势：
 *  1.它们有名称；
 *  2.不必在每次调用它们的时候都创建一个新对象；
 *  3.它们可以返回原返回类型的任何子类型的对象；
 *  4.在创建参数化类型实例的时候，它们使代码变得更加简洁。
 * 缺点：
 *  1.类如果不含公有的或者受保护的构造器，就不能被子类化；
 *  2.它们与其他的静态方法实际上没有任何区别。
 */
public class Test {
    public static void main(String[] args) {
        // Providers would execute these lines
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);

        // Clients would execute these lines
        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        Service s3 = Services.newInstance("armed");
        System.out.printf("%s, %s, %s%n", s1, s2, s3);
        // 实例受控的类
        Boolean.valueOf(true);
    }

    private static Provider DEFAULT_PROVIDER = () -> new Service() {
        @Override
        public String toString() {
            return "Default service";
        }
    };

    private static Provider COMP_PROVIDER = () -> new Service() {
        @Override
        public String toString() {
            return "Complementary service";
        }
    };

   /* private static Provider xx = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return super.toString();
                }
            };
        }
    };*/

    private static Provider ARMED_PROVIDER = () -> new Service() {
        @Override
        public String toString() {
            return "Armed service";
        }
    };
}
