package codealpha.employee;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	private String name;
	private int id;
	private double salary;

	public Employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}

class PayrollSystem {
	private ArrayList<Employee> employees;

	public PayrollSystem() {
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
		System.out.println("Employee Saved Successfully.");
	}

	public void removeEmployee(int id) {
		boolean removed = false;
		for (Employee emp : employees) {
			if (emp.getId() == id) {
				employees.remove(emp);
				removed = true;
				break;
			}
		}
		if (removed) {
			System.out.println("Employee with ID " + id + " removed successfully.");
		} else {
			System.out.println("Employee with ID " + id + " not found.");
		}
	}

	public void displayAllEmployees() {
		if (employees.isEmpty()) {
			System.out.println("No employees found.");
		} else {
			System.out.println("Employee List:");
			for (Employee emp : employees) {
				System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary());
			}
		}
	}

	public void calculatePayroll() {
		double totalPayroll = 0;
		for (Employee emp : employees) {
			totalPayroll += emp.getSalary();
		}
		System.out.println("Total Payroll: " + totalPayroll);
	}

	public void displayEmployeeDetails(int id) {
		boolean found = false;
		for (Employee emp : employees) {
			if (emp.getId() == id) {
				System.out.println("Employee Details:");
				System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Employee with ID " + id + " not found.");
		}
	}
}

public class EmployeePayrollSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PayrollSystem payrollSystem = new PayrollSystem();

		int choice;
		do {
			System.out.println("1. Add Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Display All Employees");
			System.out.println("4. Calculate Payroll");
			System.out.println("5. Display Employee Details");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter employee name: ");
				String name = sc.next();
				System.out.print("Enter employee ID: ");
				int id = sc.nextInt();
				System.out.print("Enter employee salary: ");
				double salary = sc.nextDouble();
				Employee newEmployee = new Employee(name, id, salary);
				payrollSystem.addEmployee(newEmployee);
				break;
			case 2:
				System.out.print("Enter employee ID to remove: ");
				int removeId = sc.nextInt();
				payrollSystem.removeEmployee(removeId);
				break;
			case 3:
				payrollSystem.displayAllEmployees();
				break;
			case 4:
				payrollSystem.calculatePayroll();
				break;
			case 5:
				System.out.print("Enter employee ID to display details: ");
				int displayId = sc.nextInt();
				payrollSystem.displayEmployeeDetails(displayId);
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 6);
		sc.close();
	}

}
