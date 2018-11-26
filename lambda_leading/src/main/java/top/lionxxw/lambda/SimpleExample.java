package top.lionxxw.lambda;

import top.lionxxw.bean.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

/**
 * 一些简单例子
 * Package top.lionxxw.lambda
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/1 14:34
 * version 1.0.0
 */
public class SimpleExample {

    /**
     * foreach 例子
     */
    public static void demo1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // 以前的循环方式
        System.out.println("========== 以前的循环方式=========");
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println();
        System.out.println("========== 使用 lambda 表达式以及函数操作(functional operation)=========");
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        System.out.println();
        System.out.println("========== 在 Java 8 中使用双冒号操作符(double colon operator)=========");
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    /**
     * 匿名内部类 用线程类用例子
     */
    public static void demo2() {
        // 使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("on click!!!");
            }
        }).start();

        // 使用 lambda expression
        new Thread(() -> System.out.println("on xxx click!!!")).start();

        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");

        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }


    /**
     * 使用lambda排序
     */
    public static void demo3() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
       /* Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });*/

        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);


        // 1.3 也可以采用如下形式:
//        Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));

        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });

        // 1.2 使用 lambda expression 排序,根据 surname
        Comparator<String> sortBySurname = (String s1, String s2) ->
                (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players, sortBySurname);

        // 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(players, (String s1, String s2) ->
                (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))))
        );

        // 2.1 使用匿名内部类根据 name lenght 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

        // 2.2 使用 lambda expression 排序,根据 name lenght
        Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
        Arrays.sort(players, sortByNameLenght);

        // 2.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // 3.2 使用 lambda expression 排序,根据最后一个字母
        Comparator<String> sortByLastLetter =
                (String s1, String s2) ->
                        (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);

        // 3.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));

        System.out.println(Arrays.toString(players));
    }

    /**
     * 使用Lambdas和Streams
     * Stream是对集合的包装,通常和lambda一起使用。
     * 使用lambdas可以支持许多操作,如 map, filter, limit, sorted, count, min, max, sum, collect 等等。
     * 同样,Stream使用懒运算,他们并不会真正地读取所有数据,遇到像getFirst() 这样的方法就会结束链式语法。
     */
    public static void demo4() {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };

        System.out.println("所有程序员姓名：");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        System.out.println("给程序员加薪 5%");
        Consumer<Person> addSalary = e -> e.setSalary((int) (e.getSalary() * 1.05));
        javaProgrammers.forEach(addSalary);
        phpProgrammers.forEach(addSalary);
        javaProgrammers.forEach(System.out::println);
        phpProgrammers.forEach(System.out::println);

        System.out.println("过滤出月薪超过1400的PHP程序员");
        phpProgrammers.stream().filter((p) -> (p.getSalary() > 1400)).forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // 定义filter
        Predicate<Person> ageFilter = person -> (person.getAge() > 25);
        Predicate<Person> salaryFilter = person -> (person.getSalary() > 1400);
        Predicate<Person> genderFilter = person -> ("female".equals(person.getGender()));
        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter).
                forEach(person -> System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));

        // 重用filters
        System.out.println("年龄大于 24岁的女性 Java programmers:");
        javaProgrammers.stream().filter(ageFilter).filter(genderFilter)
                .forEach(person -> System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));

        // 使用limit限制结果集个数
        System.out.println("最前面的3个 Java programmers:");
        javaProgrammers.stream().limit(3).forEach(person -> System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));

        System.out.println("最前面的3个女性 Java programmers:");
        javaProgrammers.stream().filter(genderFilter).limit(3).forEach(person -> System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));

        // 对结果集排序操作
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> collect = javaProgrammers.stream().sorted((p1, p2) -> (p1.getFirstName().compareTo(p2.getFirstName()))).limit(5).collect(toList());
        collect.forEach(person -> System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));

        System.out.println("根据 salary 排序 Java programmers:");
        List<Person> salarySort = javaProgrammers.stream().sorted((p1, p2) -> (p1.getSalary() - p2.getSalary())).collect(toList());
        salarySort.forEach(System.out::println);


        // min，max 方法使用
        System.out.println("工资最低的 Java programmer:");
        Person person = javaProgrammers.stream().min((p1, p2) -> p1.getSalary() - p2.getSalary()).get();
        System.out.println(person);

        System.out.println("工资最高的 Java programmer:");
        Person person1 = javaProgrammers.stream().max(Comparator.comparingInt(Person::getSalary)).get();
        System.out.println(person1);

        /**
         * collect 方法的使用
         * 结合 map 方法,我们可以使用 collect 方法来将我们的结果集放到一个字符串,一个 Set 或一个TreeSet中:
         */
        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        String firstNames = phpProgrammers.stream().map(Person::getFirstName).collect(joining(";"));
        System.out.println(firstNames);

        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> set = javaProgrammers.stream().map(Person::getFirstName).collect(toSet());
        System.out.println(set);

        System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");
        TreeSet<String> treeSet = javaProgrammers.stream().map(Person::getFirstName).collect(toCollection(TreeSet::new));
        System.out.println(treeSet);

        // sum方法的使用
        System.out.println("计算付给 Java programmers 的所有money:");
        int sum = javaProgrammers.parallelStream().mapToInt(p -> p.getSalary()).sum();
        System.out.println(sum);
        IntSummaryStatistics summary = javaProgrammers.stream().mapToInt(p -> p.getSalary()).summaryStatistics();
        System.out.println("Java programmers中最大的薪资 : " + summary.getMax());
        System.out.println("Java programmers中最小的薪资 : " + summary.getMin());
        System.out.println("Java programmers所有薪资的总和   : " + summary.getSum());
        System.out.println("Java programmers所有薪资的平均值 : " + summary.getAverage());
        System.out.println("Java programmers总数 : " + summary.getCount());


        /**
         * 我们可以使用summaryStatistics方法获得stream 中元素的各种汇总数据。
         * 接下来,我们可以访问这些方法,比如getMax, getMin, getSum或getAverage:
         *
        //计算 count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }

    public static void main(String[] args) {
//        demo4();

        String[] dates = {"2017-01-01","2016-07-01","2017-07-03","2017-07-11","2016-03-01","2013-02-01","2017-03-01"};

        List<String> collect = Arrays.asList(dates).stream().sorted((s1, s2) -> (s2.compareTo(s1))).collect(toList());
        System.out.println(collect);

        /**
         * map 分组操作
         */
      /*  Map<String, List<InsuranceRecordModel>> map = records.stream()
                .collect(Collectors.groupingBy(InsuranceRecordModel::getInsuranceCode));*/
    }
}
