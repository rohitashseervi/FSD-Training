package student.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

   
    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    
    public void saveStudent(Student student) {
        Session session = factory.openSession();           
        Transaction tx = session.beginTransaction();       
        session.persist(student);                          
        tx.commit();                                       
        session.close();                                   
    }

    
    public List<Student> getAllStudents() {
        Session session = factory.openSession();
                List<Student> students =
                session.createQuery("FROM Student", Student.class).list();
        session.close();                                   
        return students;
    }

    // ---------- READ ONE (helper, used by update
    public Student getStudent(int id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);  
        session.close();
        return student;
    }

   
    public void updateStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(student);                            
        tx.commit();
        session.close();
    }

   
    public void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);  // first find the student...
        if (student != null) {                             // ...only delete if it actually exists
            session.remove(student);                       // remove = DELETE the row
        }
        tx.commit();
        session.close();
    }
}
