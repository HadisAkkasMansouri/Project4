package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.Customer;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.LoggerUtil;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerDAO extends Customer {

    public boolean checkUniqueRealNationalCode(String nationalCode) throws DuplicateEntranceException {

        Session session = SessionConnection.getSessionConnection().openSession();
        try {
            Query query = session.createQuery("select rc.id from RealCustomer rc where rc.nationalCode= :nationalCode");
            System.out.println(query);
            query.setParameter("nationalCode", nationalCode);
            List result = query.getResultList();
            LoggerUtil.getLogger().info("The national code is unique.");
            if (!result.isEmpty()) {
                LoggerUtil.getLogger().warn("The national code is not unique!");
                throw new DuplicateEntranceException("کد ملی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
            }
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The checking of national code has been faced with error!");
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return true;
    }

    public RealCustomer addRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) throws DuplicateEntranceException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        RealCustomer realCustomer = new RealCustomer();
        try {
            int customerNum = CustomerDAO.retrieveMaxCustomerNumber();
            String customerNumber = String.valueOf(customerNum);
            transaction = session.beginTransaction();
            if (checkUniqueRealNationalCode(nationalCode)) {
                realCustomer = new RealCustomer(customerNumber, name, familyName, fatherName, birthDate, nationalCode);
                session.save(realCustomer);
                transaction.commit();
                LoggerUtil.getLogger().info("The adding of real customer has been done successfully.");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                LoggerUtil.getLogger().warn("The adding of real customer has not been done!");
                e.printStackTrace();
            }
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return realCustomer;
    }

    public boolean deleteRealCustomer(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            if (CustomerDAO.deleteCustomer(id)) {
                Query query = session.createQuery("delete from RealCustomer rc where rc.id= :id");
                System.out.println(query);
                query.setParameter("id", id);
                query.executeUpdate();
                transaction.commit();
                LoggerUtil.getLogger().info("The real customer has been deleted successfully.");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                LoggerUtil.getLogger().warn("The real customer has not been deleted!");
                e.printStackTrace();
                return false;
            }
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return true;
    }


    public Query buildRealCustomerQuery(String name, String familyName, String nationalCode, String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Query query = null;
        int counter = 1;
        StringBuilder queryString = new StringBuilder("from RealCustomer rc, Customer c where rc.id = c.id and ");
        List<String> parameters = new ArrayList<String>();
        if ((customerNumber != null) && (!customerNumber.trim().equals(""))) {
            queryString.append("c.customerNumber= :customerNumber and ");
            parameters.add(customerNumber);
        }
        if ((name != null) && (!name.trim().equals(""))) {
            queryString.append("rc.name= :name and ");
            parameters.add(name);
        }
        if ((familyName != null) && (!familyName.trim().equals(""))) {
            queryString.append("rc.familyName= :familyName and ");
            parameters.add(familyName);
        }
        if ((nationalCode != null) && (!nationalCode.trim().equals(""))) {
            queryString.append("rc.nationalCode= :nationalCode and ");
            parameters.add(nationalCode);
        }
        queryString.append("true");
        try {
            query = session.createQuery(queryString.toString());
            for (String parameter : parameters) {
                query.setParameter(counter, parameter);
                counter++;
            }
            LoggerUtil.getLogger().info("The Query of real customer building has been done successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The Query of real customer building has not been done!");
          e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return query;
    }

    public List<RealCustomer> searchRealCustomer(String name, String familyName, String nationalCode, String customerNumber) {

        List<RealCustomer> result = new ArrayList<RealCustomer>();
        Session session = SessionConnection.getSessionConnection().openSession();

        try {
            Query query = buildRealCustomerQuery(name, familyName, nationalCode, customerNumber);
            List<RealCustomer> realCustomers = query.getResultList();
            for (RealCustomer realCustomer : realCustomers) {
                result.add(realCustomer);
            }
            LoggerUtil.getLogger().info("The retrieval of real customer has been done successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The retrieval of real customer has not been done!");
                e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return result;
    }

    public RealCustomer updateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode, String customerNumber) throws Exception {

        int id = CustomerDAO.retrieveIdByCustomerNumber(customerNumber);
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update RealCustomer rc set rc.name= :name, rc.familyName= :familyName, rc.fatherName= : fatherName," +
                    " rc.birthDate= :birthDate, rc.nationalCode= :nationalCode where rc.id= :id");
            query.setParameter("name", name);
            query.setParameter("familyName", familyName);
            query.setParameter("fatherName", fatherName);
            query.setParameter("birthDate", birthDate);
            query.setParameter("nationalCode", nationalCode);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            LoggerUtil.getLogger().info("The real customer has been updated successfully.");
            return new RealCustomer(customerNumber, name, familyName, fatherName, birthDate, nationalCode);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                LoggerUtil.getLogger().error("The real customer has not been updated!");
                e.printStackTrace();
            }
            throw new Exception("عملیات اصلاح موفقیت آمیز نبود!");
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }

    public RealCustomer getRealCustomer(int id) throws NotFoundDataException {

        Session session = SessionConnection.getSessionConnection().openSession();
        try {
            Query query = session.createQuery("select rc from RealCustomer rc where rc.id= :id");
            query.setParameter("id", id);
            Object realCustomer = query.getFirstResult();
            LoggerUtil.getLogger().info("The real customer has been retrieved with mentioned Id.");
            return (RealCustomer) realCustomer;
        }catch(Exception e){
            LoggerUtil.getLogger().info("The real customer has not been retrieved with mentioned Id!");
            e.printStackTrace();
            throw new NotFoundDataException("مشتری با id مورد نظر یافت نشد.");
        }
        finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }

    public RealCustomer retrieveRealCustomerName(String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        RealCustomer realCustomer = new RealCustomer();
        try {
            Query query = session.createQuery("select rc from RealCustomer rc, Customer c  where rc.id = c.id and c.customerNumber= :customerNumber");
            query.setParameter("customerNumber", customerNumber);
            realCustomer = (RealCustomer) query.getSingleResult();
            LoggerUtil.getLogger().info("The real customer has been retrieved with mentioned customer number.");
        }catch (Exception e){
            LoggerUtil.getLogger().info("The real customer has not been retrieved with mentioned customer number!");
            e.printStackTrace();
        }finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return realCustomer;
    }
}
