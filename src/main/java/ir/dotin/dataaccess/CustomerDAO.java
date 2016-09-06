package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.Customer;
import ir.dotin.utility.LoggerUtil;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

public class CustomerDAO {

    public static int addCustomer(String customerNumber){

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = retrieveMaxId();
        try {
            transaction = session.beginTransaction();
            Customer customer = new Customer( customerNumber);
            id = (Integer) session.save(customer);
            transaction.commit();
            LoggerUtil.getLogger().info("The real customer has been inserted successfully.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                LoggerUtil.getLogger().error("The real customer has not been inserted!");
                e.printStackTrace();
            }
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return id;
    }

    public static int retrieveMaxCustomerNumber() {

        Session session = SessionConnection.getSessionConnection().openSession();
        int customerNumber = 0;
        try {
            Query query = session.createQuery("select max(c.customerNumber) from Customer c");
            System.out.println(query);
            String result = (String) query.getSingleResult();
            if (result !=  null && !result.equals("")) {
                customerNumber = Integer.parseInt(result) + 1;
            } else {
                customerNumber = 10000;
            }
            LoggerUtil.getLogger().info("The retrieval of maximum customer number has been done successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The retrieval of maximum customer number has not been done!");
                e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
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
            LoggerUtil.getLogger().info("The real customer has been deleted successfully.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                LoggerUtil.getLogger().error("The real customer has not been deleted!");
                e.printStackTrace();
            }
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return true;
    }

    public static int retrieveMaxId() {

        Session session = SessionConnection.getSessionConnection().openSession();
        int id = 0;
        try {
            Query query = session.createQuery("select max(c.id) from Customer c");
            System.out.println(query);
            Object result = query.getFirstResult();
            if ((Integer) result != 0) {
                id++;
            } else {
                id = 1;
            }
            LoggerUtil.getLogger().info("The retrieval of maximum id has been done successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The retrieval of maximum id has not been done!");
                e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return id;
    }

    public static String retrieveCustomerNumberById(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        String customerNumber = null;
        try {
            Query query = session.createQuery("select c.customerNumber from Customer c where c.id= :id");
            System.out.println(query);
            query.setParameter("id", id);
            Object result = query.getSingleResult();
            if ((String) result != null) {
                customerNumber = (String) result;
            }
            LoggerUtil.getLogger().info("The retrieval of customer number by Id has been done successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The retrieval of customer number by Id has not been done!");
            e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return customerNumber;
    }

    public static int retrieveIdByCustomerNumber(String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        int id = 0;
        try {
            Query query = session.createQuery("select c.id from Customer where customerNumber= :customerNumber");
            System.out.println(query);
            query.setParameter("customerNumber", customerNumber);
            Object result = query.getSingleResult();
            if ((Integer) result != 0) {
                id = (Integer) result;
                LoggerUtil.getLogger().warn("The retrieval of Id by customer number has been done successfully.");
            }
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The retrieval of Id by customer number has not been done!");
                e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return id;
    }
}
