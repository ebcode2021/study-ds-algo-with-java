import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
 * lambda vs 메소드 참조
 */
public class streamApiCompare {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(49.1, 25.5, 9.9);
        
        // lambda
        numbers.stream() // 스트림 API
                .map(n -> Math.round(n))
                .forEach(n -> System.out.println(n));

        // 메소드 참조
        numbers.stream() // 스트림 API
                .map(Math::round)
                .forEach(System.out::println);
    }
    

}


