package top.lionxxw.item2.builder;// Builder Pattern - Pages 14-15

/**
 * 第二条:遇到多个构造器参数时要考虑用构造器
 * 如果类的构造器或者静态工厂中具有多个参数，设计这种类时，Builder模式就是中不错的选择，
 * 特别是当大多数参数都是可选的时候。与使用传统的重叠构造器模式相比，使用Builder模式的
 * 客户端代码将更易于阅读和编写，构建器也比JavaBeans更安全
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int carbohydrate  = 0;
        private int sodium        = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val)
            { calories = val;      return this; }
        public Builder fat(int val)
            { fat = val;           return this; }
        public Builder carbohydrate(int val)
            { carbohydrate = val;  return this; }
        public Builder sodium(int val)
            { sodium = val;        return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8).
            calories(100).sodium(35).carbohydrate(27).build();
    }
}