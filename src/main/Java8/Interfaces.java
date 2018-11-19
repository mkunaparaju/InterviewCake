package main.Java8;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.util.Comparator;

public class Interfaces {
    public static void main(String[] args) {
        Employee mike = new Employee("Mike", 2000),
                louise = new Employee("Louise", 2500);

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };

        System.out.println("By name");
        System.out.println(byName.compare(mike,louise));
        try {
            System.out.println(byName.compare(mike, null));
        }
        catch (NullPointerException e ){
            System.out.println(e);
        }

    }
}
