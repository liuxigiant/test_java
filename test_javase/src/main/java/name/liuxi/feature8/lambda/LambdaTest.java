package name.liuxi.feature8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "c", "b");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        List<String> list2 = Arrays.asList("a", "c", "b");
        list2.sort((String o1, String o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(list2);
    }
}
