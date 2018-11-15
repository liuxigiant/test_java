package name.liuxi.feature8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("sa", "sc", "b");
        list.stream()
                .filter((e) -> e.startsWith("s"))
                .forEach(e -> System.out.println(e));
        System.out.println(list);
    }
}
