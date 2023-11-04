package com.durcare.eurekaserverserviceapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.google.common.base.Predicate;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceAppApplication.class, args);
		
		Date now=new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		System.out.println(now);
		
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		System.out.println(now);
		

		//Java switch case String make code more readable by removing the multiple if-else-if chained conditions.
		//Java switch case String is case sensitive
		String technology = "java";

		switch (technology) {
		case "Java":
			System.out.println("Back-End Developer...!!!");
			break;
		case "Html":
			System.out.println("Front-End Developer...!!!");
			break;
		default:
			System.out.println("Non-Technical...!!!");
		}

		// Lambda Expression
		new Thread(() -> System.out.println("New Thread Created...!!!!")).start();

		Consumer<String> consumer = (name) -> System.out.println(name.toUpperCase());
		consumer.accept("raghu konda");

		BiConsumer<Integer, Integer> multiplication = (a, b) -> System.out.println(a * b);
		BiConsumer<Integer, Integer> addition = (a, b) -> System.out.println(a + b);
		addition.andThen(multiplication).accept(12, 10);

		Predicate<String> predicate = (name) -> name.length() == 3;
		System.out.println(predicate.apply("Java"));

		BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a % b == 0);
		BiPredicate<Integer, Integer> biPredicate2 = (a, b) -> (a + b == 50);
		System.out.println(biPredicate.and(biPredicate2).test(25, 25));

		Function<String, Integer> function = x -> x.length();
		System.out.println(function.apply("Raghu"));

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		BiFunction<Integer, Integer, Integer> andThen = add.andThen(a -> 10 * a);
		System.out.println(andThen.apply(12, 10));

		Supplier<List<Integer>> supplier = () -> {
			List<Integer> integers = new ArrayList<>();
			integers.add(12);
			return integers;
		};
		System.out.println(supplier.get());

		List<Employee> empList = Arrays.asList(
				new Employee(12, "Raghu", "Male", "Java Developer", LocalDate.of(2021, 10, 12)),
				new Employee(13, "Likitha", "female", "Testing Developer", LocalDate.of(2020, 1, 22)),
				new Employee(14, "Shiva", "Male", "Testing Developer", LocalDate.of(2022, 8, 10)),
				new Employee(15, "Arun", "Male", "React Developer", LocalDate.of(2021, 10, 22)),
				new Employee(15, "Shaveena", "female", "Angular Developer", LocalDate.of(2023, 4, 17)));

		System.err.println("Group the employees based on the gender and print the records...!!!");
		empList.stream().collect(Collectors.groupingBy(Employee::getGender)).forEach((string, list) -> {
			System.out.println(string);
			list.forEach(System.out::println);
		});

		System.err.println("Find male and female employees are there in the organization...!!!");
		empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
				.forEach((gender, count) -> {
					System.out.println(gender + " :: " + count);
				});
		System.err.println("List down the employees of each department...!!!");
		empList.stream().collect(Collectors.groupingBy(Employee::getName)).forEach((name, list) -> {
			list.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((dep, lists) -> {
				System.out.println(name + " :: " + dep);

			});

		});

		System.err.println("Print the names of all departments in the organization...!!!");

		empList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((dep, lists) -> {
			System.out.println(dep);

		});

		System.err.println("Find how male and female employees are there in the testing team...!!!");
		empList.stream().collect(Collectors.groupingBy(Employee::getGender)).forEach((gender, list) -> {
			long count = list.stream().filter(dep -> dep.getDepartment().equalsIgnoreCase("Testing Developer")).count();
			System.out.println(gender + " :: " + count);
		});

		System.err.println("Get the Names of employees who joined after 2022....!!!");
		empList.stream().filter(date -> date.getDoj().isAfter(LocalDate.of(2022, 1, 1)))
				.collect(Collectors.groupingBy(Employee::getName)).forEach((name, list) -> {
					System.out.println(name);
				});

		System.err.println("<><><><><><><><><><><><><><><><><><><><><><><><><>");

		System.err.println("Find first object from given list....!!!");
		Optional<Employee> optional = empList.stream().findFirst();
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}

		System.err.println("Print the list of elements....!!!");
		if (!empList.isEmpty()) {
			Optional<List<Employee>> nullable = Optional.ofNullable(empList);
			if (nullable.isPresent()) {
				System.out.println(nullable.get());
			}
		}

		System.err.println("Find first department from the given list....!!!");
		Optional<String> findFirst = empList.stream().map(Employee::getDepartment).findFirst();
		if (findFirst.isPresent()) {
			System.out.println(findFirst.get());
		}

		System.err.println("Find first department " + " the given list....!!!");
		String string = empList.stream().map(Employee::getDepartment).findFirst()
				.orElse("No Element Present in given list..!!");
		System.out.println(string);

		System.err.println("Get the Names of employees who joined after 2022....!!!");
		Map<String, List<Employee>> map = empList.stream()
				.filter(date -> date.getDoj().isAfter(LocalDate.of(2022, 1, 1)))
				.collect(Collectors.groupingBy(Employee::getName));
		Optional<Map<String, List<Employee>>> optional2 = Optional.of(map);
		if (optional2.isPresent()) {
			System.out.println(optional2.get());
		}

	}

}
