package employee.employee;

import java.time.LocalDate;   // used for the joining date (jdate)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                        // this class maps to a database table
@Table(name = "employee")      // the table will be named "employee"
public class Employee {

    @Id                                              // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // MySQL auto-increments it
    private int employeeId;

    private String employeeName;

    private String department;

    private double salary;

    private LocalDate jdate;    // joining date -> stored as a DATE column

    // No-argument constructor required by Hibernate
    public Employee() {
    }

    // Convenience constructor (no id — the DB generates it)
    public Employee(String employeeName, String department, double salary, LocalDate jdate) {
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.jdate = jdate;
    }

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJdate() {
        return jdate;
    }

    public void setJdate(LocalDate jdate) {
        this.jdate = jdate;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName
                + ", department=" + department + ", salary=" + salary
                + ", jdate=" + jdate + "]";
    }
}
