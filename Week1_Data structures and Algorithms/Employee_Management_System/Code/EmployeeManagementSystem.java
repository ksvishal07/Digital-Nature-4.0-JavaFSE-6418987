package Employee_Management_System.Code;

import java.util.Scanner;

public class EmployeeManagementSystem {
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', position='%s', salary=%.2f}", employeeId, name, position, salary);
        }
    }

    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) return false;
        employees[size++] = emp;
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) return employees[i];
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                employees[i] = employees[size - 1]; // Replace with last
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. Search Employee\n3. Traverse Employees\n4. Delete Employee\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String pos = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = scanner.nextDouble();
                    if (ems.addEmployee(new Employee(id, name, pos, sal))) {
                        System.out.println("Employee added.");
                    } else {
                        System.out.println("Array full. Cannot add more employees.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int sid = scanner.nextInt();
                    Employee found = ems.searchEmployee(sid);
                    if (found != null) System.out.println(found);
                    else System.out.println("Employee not found.");
                    break;
                case 3:
                    ems.traverseEmployees();
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int did = scanner.nextInt();
                    if (ems.deleteEmployee(did)) System.out.println("Employee deleted.");
                    else System.out.println("Employee not found.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
