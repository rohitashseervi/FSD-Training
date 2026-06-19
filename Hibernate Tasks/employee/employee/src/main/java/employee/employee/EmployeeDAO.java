package employee.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

    // Built ONCE, reused for every operation
    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    // ---------- CREATE ----------
    public void saveEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        session.close();
    }

    // ---------- READ ALL ----------
    public List<Employee> getAllEmployees() {
        Session session = factory.openSession();
        List<Employee> employees =
                session.createQuery("FROM Employee", Employee.class).list();
        session.close();
        return employees;
    }

    // ---------- READ ONE (helper, used by update) ----------
    public Employee getEmployee(int id) {
        Session session = factory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    // ---------- UPDATE ----------
    public void updateEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(employee);
        tx.commit();
        session.close();
    }

    // ---------- DELETE ----------
    public void deleteEmployee(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.remove(employee);
        }
        tx.commit();
        session.close();
    }
}
