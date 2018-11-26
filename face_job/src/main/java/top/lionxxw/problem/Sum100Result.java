package top.lionxxw.problem;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 问题5
 * 编写一个在1，2，…，9（顺序不能变）数字之间插入+或-或什么都不插入，使得计算结果总是100的程序，并输出所有的可能性。
 * 例如：1+2+34-5+67-8+9 = 100。
 */
public class Sum100Result {
    private static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public static void main(String[] args) throws ScriptException {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sum100(nums);
    }

    public static void sum100(Integer[] nums) throws ScriptException {
        Set<String> ss = new HashSet<>();
        String[] suffix = {"+","-",""};
        long start = System.currentTimeMillis();
        boolean flag = true;
        while (flag){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(suffix[new Random().nextInt(3)]).append(nums[i]);
            }
            BigDecimal eval = eval(sb.toString());
            if (eval.toString().equals("100.00")){
                if (sb.toString().startsWith("+")){
                    sb = new StringBuilder(sb.toString().substring(1));
                }
                if (ss.add(sb.toString())){
                    start = System.currentTimeMillis();
                    System.out.printf("公式：%s =%s", sb.toString(), eval);
                    System.out.println();
                }
            }
            if (System.currentTimeMillis() - start > 10000){
                flag = false;
                System.out.println("程序完毕！");
            }
        }
    }

    public static BigDecimal eval(String str) throws ScriptException {
        return new BigDecimal(jse.eval(str).toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
