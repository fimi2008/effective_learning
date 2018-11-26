package top.lionxxw.java8.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Package top.lionxxw.java8.stream
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/25 13:43
 * version 1.0.0
 */
public class StreamsExample {
    private enum Status {
        OPEN, CLOSED;
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "status=" + status +
                    ", points=" + points +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        Collection<Task> tasks = Arrays.asList(
                new Task(Status.CLOSED, 5),
                new Task(Status.CLOSED, 13),
                new Task(Status.OPEN, 1));

        int sum = tasks.stream().filter(task -> task.getStatus() == Status.CLOSED).mapToInt(Task::getPoints).sum();

        System.out.println("Total points: " + sum);

        double total = tasks.stream().parallel().map(Task::getPoints).reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + total);

        /**
         * 对集合中的元素进行分组
         */
        final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        /**
         * 计算整个集合中每个task分数（或权重）的平均值
         */
        List<String> collect = tasks
                .stream()               // Stream< String >
                .mapToInt(Task::getPoints)// IntStream
                .asLongStream()// LongStream
                .mapToDouble(points -> points / total)// DoubleStream
                .boxed()// Stream< Double >
                .mapToLong(weight -> (long) (weight * 100))// LongStream
                .mapToObj(percentage -> percentage + "%")// Stream< String>
                .collect(Collectors.toList());// List< String >
        System.out.println(collect);

        String fileName = "E:\\data\\demo.txt";
        /*Path path = new File(fileName).toPath();
        try {
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        final Path path = new File(fileName).toPath();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        }
    }
}
