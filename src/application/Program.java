package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entites.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner (System.in);
		
		List<Employee> list = new ArrayList();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				Employee employee = new Employee(fields[0], fields[1], Double.parseDouble(fields[2]));
				list.add(employee);
				line = br.readLine();
			}
			
			System.out.print("Enter salary: ");
			Double salary = sc.nextDouble();
			
			List<String> listEmail = list.stream()
					.filter(e -> e.getSalary() >= salary)
					.map(e -> e.getEmail())
					.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
					.collect(Collectors.toList());
			
			System.out.print(String.format("Email of people whose salary is more than %.2f:", salary));
			listEmail.forEach(System.out::println);
			
			char ch = 'M';
			
			double sum = list.stream().
					filter(e -> e.getName().toUpperCase().charAt(0) == ch).
					map(e -> e.getSalary()).
					reduce(0.0, (x,y) -> x + y);
			
			System.out.println(String.format("Sum of salary of people whose name starts with 'M': %.2f", sum));
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
		
	}

}
