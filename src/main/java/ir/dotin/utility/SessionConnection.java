package ir.dotin.utility;

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
}
