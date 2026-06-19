package employee.employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();    // also builds the SessionFactory + table
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Read All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:  // ---------- INSERT ----------
                    sc.nextLine();              // clear leftover newline after nextInt()
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String department = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();              // clear newline again before reading the date text
                    System.out.print("Enter joining date (yyyy-MM-dd): ");
                    LocalDate jdate = LocalDate.parse(sc.nextLine());   // text -> LocalDate
                    dao.saveEmployee(new Employee(name, department, salary, jdate));
                    System.out.println("Employee inserted successfully!");
                    break;

                case 2:  // ---------- READ ALL ----------
                    List<Employee> employees = dao.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:  // ---------- UPDATE ----------
                    System.out.print("Enter id of employee to update: ");
                    int updateId = sc.nextInt();
                    Employee existing = dao.getEmployee(updateId);
                    if (existing == null) {
                        System.out.println("Employee not found.");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    existing.setEmployeeName(sc.nextLine());
                    System.out.print("Enter new department: ");
                    existing.setDepartment(sc.nextLine());
                    System.out.print("Enter new salary: ");
                    existing.setSalary(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Enter new joining date (yyyy-MM-dd): ");
                    existing.setJdate(LocalDate.parse(sc.nextLine()));
                    dao.updateEmployee(existing);
                    System.out.println("Employee updated successfully!");
                    break;

                case 4:  // ---------- DELETE ----------
                    System.out.print("Enter id of employee to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    System.out.println("Employee deleted (if it existed).");
                    break;

                case 5:  // ---------- EXIT ----------
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
