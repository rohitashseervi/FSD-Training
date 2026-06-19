package order.order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    public void saveOrder(Order order) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(order);
        tx.commit();
        session.close();
    }

    public List<Order> getAllOrders() {
        Session session = factory.openSession();
        List<Order> orders =
                session.createQuery("FROM Order", Order.class).list();
        session.close();
        return orders;
    }

    public Order getOrder(int id) {
        Session session = factory.openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    public void updateOrder(Order order) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(order);
        tx.commit();
        session.close();
    }

    public void deleteOrder(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Order order = session.get(Order.class, id);
        if (order != null) {
            session.remove(order);
        }
        tx.commit();
        session.close();
    }
}
