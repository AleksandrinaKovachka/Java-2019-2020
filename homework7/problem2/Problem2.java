package problem2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2
{
    public static void main(String[] args)
    {
        List<String> list =  Stream.of("aBc", "d", "ef", "123456")
                .map(s -> s.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
