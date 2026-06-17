package EntryLevel.CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee;
            if (data.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (data.length == 5) {
                if (data[4].contains("@")) {
                    employee = new Employee(name, salary, position, department, data[4]);
                } else {
                    employee = new Employee(name, salary, position, department, Integer.parseInt(data[4]));
                }
            } else {
                employee = new Employee(name, salary, position, department, data[4], Integer.parseInt(data[5]));
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).addEmployee(employee);
        }

        Department best = departments.values()
                .stream()
                .max(Comparator.comparingDouble(Department::getAverageSalary))
                .orElse(null);

        System.out.println("Highest Average Salary: " + best.getName());

        best.getEmployees().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(e -> System.out.printf("%s %.2f %s %d%n",
                        e.getName(),
                        e.getSalary(),
                        e.getEmail(),
                        e.getAge()));

    }
}
