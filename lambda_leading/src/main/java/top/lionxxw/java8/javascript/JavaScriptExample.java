package top.lionxxw.java8.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Package top.lionxxw.java8.javascript
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/25 15:50
 * version 1.0.0
 */
public class JavaScriptExample {
    /**
     * Nashorn，一个新的JavaScript引擎随着Java 8一起公诸于世，它允许在JVM上开发运行某些JavaScript应用。
     * Nashorn就是javax.script.ScriptEngine的另一种实现，并且它们俩遵循相同的规则，允许Java与JavaScript相互调用。
     */
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        System.out.println("Result:" + engine.eval("function f(){return 1;}; f()+1;"));
    }
}
