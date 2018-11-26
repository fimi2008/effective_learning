package top.lionxxw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 学习下什么是正则表达式

 * created on 2017/12/9 13:56
 *
 * @author lionxxw
 * @version 1.0.0
 */
public class HelloRegx {

    /**
     * 2个关键类
     * Mather
     * Pattern
     */
    public static void regCompile(String text, String regex) {
        // 第一步:构造一个regex模式
        Pattern pattern = Pattern.compile(regex);
        // 第二步:构造一个匹配器
        Matcher matcher = pattern.matcher(text);
        // 判断是否匹配
        boolean matches = matcher.matches();
        if (matches) {
            System.out.println("验证成功");
        } else {
            System.err.println("验证失败");
        }
    }

    public static void regCompile(RegMap map, String out) {
        System.out.print(out);
        regCompile(map.getText(), map.getRegex());
    }
    public static void regCompile(String text, String regex, String out) {
        System.out.print(out);
        regCompile(text, regex);
    }

    /**
     * ^ 匹配第一个字符
     * $ 匹配最后一个字符
     *
     * @param type
     * @return
     */
    public static RegMap getRegMap(String type) {
        RegMap map = new RegMap();
        switch (type) {
            case "number":
                /**
                 * \d 代表数字,相当于[0-9]
                 */
                map.setRegex("\\d+");
                map.setText("123123123");
                break;
            case "space":
                /**
                 * \s 代表空格字符,space,tab,换行,换页,回车
                 */
                map.setRegex("\\s+");
                map.setText("   ");
                break;
            default:
                System.out.println("未匹配上");
        }
        return map;
    }

    /**
     * ^ 要匹配第一个字符
     * $ 要匹配最后一个字符
     * * 零次或多次匹配
     * + 表示一个或者多个匹配,相当于{1,}
     * ? 零次或一次匹配,相当于{0,1}
     * . 匹配除"\r\n"以外的单个字符
     * {n} 表示匹配n次
     * {n,} 表示至少匹配n次
     * {n,m} 表示至少匹配n次,最多匹配m次
     * [wrt] 表示该处字符为括号内的任意一个
     * [^wrt] 匹配非括号内的任意字符
     * \d 代表数字,相当于[0-9]
     * \D 非数字匹配,相当于[^0-9]
     * \s 代表空格字符,space,tab,换行,换页,回车
     * \S 匹配非空白字符
     * | 表示匹配中包含或者的关系
     * \w 表示一个字母,相当于[a-zA-Z_0-9]
     * \f 匹配换页符
     * \n 匹配换行符
     * \r 匹配回车符
     * \t 匹配制表符
     * @param args
     */
    public static void main(String[] args) {
        regCompile(getRegMap("number"),"数字字符匹配:");
        regCompile(getRegMap("space"),"空白字符匹配:");
        // 手机号码
        String moblieReg = "^[1][3,5,6,7,8,9]\\d{9}$";
        String moblie = "13721472363";
        regCompile(moblie, moblieReg,"手机号码验证:");
        // 邮箱
        String emailReg = "^\\w{3,}@\\w{2,}\\.com$";
        String email = "574214@163.com";
        regCompile(email, emailReg, "邮箱验证:");
        // qq号
        String qqReg = "^[1-9]\\d{3,10}";
        String qq = "574693894";
        regCompile(qq, qqReg, "qq验证:");
        // 账号包含字母数字_
        String accReg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_])\\w{8,30}$";
        String acc ="124_wiiX";
        regCompile(acc, accReg, "账号验证:");
        // 身份证号
        // 网址
        // 密码6位纯数字
        // 密码至少8位包含数字,大写字母,符号
    }

    static class RegMap {
        private String text;
        private String regex;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }
    }
}
