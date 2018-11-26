package top.lionxxw.Item3.enums;

/**
 * 第三种方法：只需编写一个包含单个元素的枚举类型
 */
// Enum singleton - the preferred approach - page 18
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
