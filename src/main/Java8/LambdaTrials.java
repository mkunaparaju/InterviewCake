package main.Java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public class LambdaTrials {

    public static void main(String[] args) {

        Comparator<String> byLength = (String a, String b) -> {return Integer.compare(a.length(), b.length()); };
        System.out.println(byLength.compare("hello", "world"));

        Comparator<Employee> byName = (Employee a, Employee b ) -> {return a.getName().compareTo(b.getName());};
//        System.out.println(byName.compare(new Employee("mike", 100), new Employee("molly", 200)));

        Comparator<Employee> byNameFinal = (a,b) -> a.getName().compareTo(b.getName()) > 0 ? 10:12 ;
        System.out.println(byNameFinal.compare(new Employee("mike", 100), new Employee("molly", 200)));

        Consumer<String> c1 = msg -> System.out.println(msg.length());
            
//
//        Random random = new Random();
//        Stream<Integer> rands = Stream.generate(random::nextInt);
//        rands.filter(n -> n>0).map(n -> n/10).limit(10).forEach(System.out::println);
//
//        String [] book = {"hello","world","today", "world", "when", "who", "wht", "why", "when"};
//        Arrays.stream(book).distinct().forEach(System.out::println);





    }

    //any type T
    //compiler infers / fills in what the type should be
    public static <T> T getFirst(T[] array) {
        return array[0];
    }


}