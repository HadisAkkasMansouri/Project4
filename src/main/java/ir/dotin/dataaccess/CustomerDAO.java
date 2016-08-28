package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.Customer;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.security.interfaces.RSAKey;
import java.sql.Connection;

public class CustomerDAO {

    static Connection connection = null;

    public static int addCustomer(String customerNumber){

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = retrieveMaxId();
        try {
            transaction = session.beginTransaction();
            Customer customer = new Customer(id, customerNumber);
            id = (Integer) session.save(customer);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return id;
    }

    public static int retrieveMaxCustomerNumber() {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int customerNumber = 0;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(c.customerNumber) from Customer c");
            System.out.println(query);
            String result = (String) query.getSingleResult();
            transaction.commit();
            if (result !=  null && !result.equals("")) {
                customerNumber = Integer.parseInt(result) + 1;
            } else {
                customerNumber = 10000;
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return customerNumber;
    }

    public static boolean deleteCustomer(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from Customer c where c.id= :id");
            System.out.println(query);
            query.setParameter("id", id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return true;
    }

    public static int retrieveMaxId() {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = 0;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(c.id) from Customer c");
            System.out.println(query);
            Object result = query.getFirstResult();
            if ((Integer) result != 0) {
                id++;
            } else {
                id = 1;
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return id;
    }

    public static String retrieveCustomerNumberById(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        String customerNumber = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select c.customerNumber from Customer c where c.id= :id");
            System.out.println(query);
            query.setParameter("id", id);
            Object result = query.getSingleResult();
            if ((String) result != null) {
                customerNumber = (String) result;
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return customerNumber;
    }

    public static int retrieveIdByCustomerNumber(String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = 0;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select c.id from Customer where customerNumber= :customerNumber");
            System.out.println(query);
            query.setParameter("customerNumber", customerNumber);
            Object result = query.getSingleResult();
            if ((Integer) result != 0) {
                id = (Integer) result;
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return id;
    }
}
