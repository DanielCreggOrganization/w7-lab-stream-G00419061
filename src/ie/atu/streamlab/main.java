package ie.atu.streamlab;

import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        //List<String> names = Arrays.asList("Alice","Bob", "Charlie", "David");

        /*names.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(name -> System.out.println(name));*/

        /*List<String> fileredNames = names.stream()
            .filter(name -> name.length()>3)
            .sorted()
            .collect(Collectors.toList());

        fileredNames.forEach(name -> System.out.println(name));*/

        /*//Using Lambda
        names.stream()
            .map(name -> name.toUpperCase())
            .forEach(name -> System.out.println(name));

        //Using method reference
        names.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);*/

        //Example 1: Sum numbers using reduce
        List<Integer> numbs = Arrays.asList(1,2,3,4,5);

        //Sum using reduce
        int sum = numbs.stream()
                .reduce(0, (a,b) -> a + b);
        System.out.println("Sum: " + sum); // output: Sum: 15

        //Example 2: Find maximum number
        int max = numbs.stream()
                .reduce(Integer.MIN_VALUE, (a,b) -> Math.max(a,b));
        System.out.println("Max value: " + max); //output: Max Value: 5

        //Example 3: Concatenate Strings
        List<String> words = Arrays .asList("Hello", " ", "World", "!");
        String combined = words.stream()
                .reduce("", (a,b) -> a + b);
        System.out.println("Combined string: " + combined); //Output: Hello World!

        /*String inputPath = "resources/input.txt";

        try(Stream<String> lines = Files.lines(Paths.get(inputPath))){
            lines.filter(line -> line.contains("Java"))
                .map(String::trim)
                .forEach(line -> System.out.println(line));
        }catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }*/

        

        //Task 2
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        nums.stream()
            .filter(n -> n % 2 != 0)
            .forEach(System.out::print);
            System.out.println("");

        //Task 3
        List<String> fruits = Arrays.asList("apple", "banana", "grape", "kiwi", "orange", "mango");
        
        List<String> filterFruits = fruits.stream()
            .filter(fruit -> fruit.length()>5)
            .sorted()
            .map(fruit -> fruit.toUpperCase())
            .collect(Collectors.toList());
        
            filterFruits.forEach(fruit -> System.out.println(fruit));

        //Task 4
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        numbers.stream()
            .map(NumbersUtils::doubleNumber)
            .forEach(System.out::println);

        //Task 5
        List<Integer> ints = Arrays.asList(2,4,6,8,10);

        int intSum = ints.stream()
                .reduce(1, (a,b)  -> a * b);
        System.out.println("Product: " + intSum);

        int min = ints.stream()
                .reduce(Integer.MAX_VALUE, (a,b) -> Math.min(a, b));
        System.out.println("MIN value: " + min);

        //Task 6
        String inputPath = "resources/input.txt";

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long count = lines.filter(line -> line.contains("Java")).count();
            System.out.println("Lines containing \"Java\": " + count);

            double averageLength = Files.lines(Paths.get(inputPath))
                    .mapToInt(String::length)
                    .average()
                    .orElse(0.0);
            System.out.println("Average line length: " + averageLength);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}
