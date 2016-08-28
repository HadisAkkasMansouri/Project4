package ir.dotin.utility;

import ir.dotin.dataaccess.CustomerDAO;
import ir.dotin.dataaccess.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnection {

    private static SessionFactory factory;
    public static SessionFactory getSessionConnection() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Failed to create sessionFactory");
            throw new ExceptionInInitializerError(e);
        }
        return factory;
    }

    public static void main(String[] args) {
        SessionFactory sessionConnection = getSessionConnection();

        CustomerDAO.addCustomer("1223");
    }
}
