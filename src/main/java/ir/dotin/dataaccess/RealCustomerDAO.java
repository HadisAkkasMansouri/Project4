package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.Customer;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.DuplicateEntranceException;
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
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select rc.id from RealCustomer rc where rc.nationalCode= :nationalCode");
            System.out.println(query);
            query.setParameter("nationalCode", nationalCode);
            List result = query.getResultList();
            transaction.commit();
            if (!result.isEmpty()) {
                throw new DuplicateEntranceException("کد ملی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
            }
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
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
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
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
                return false;
            }
        } finally {
            session.close();
        }
        return true;
    }


    public Query buildRealCustomerQuery(String name, String familyName, String nationalCode, String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        Query query = null;
        int counter = 1;
        transaction = session.beginTransaction();
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
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
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
        } catch (HibernateException e) {
                e.printStackTrace();
        } finally {
            session.close();
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
            return new RealCustomer(customerNumber, name, familyName, fatherName, birthDate, nationalCode);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            throw new Exception("عملیات اصلاح موفقیت آمیز نبود!");
        } finally {
            session.close();
        }
    }

    public RealCustomer getRealCustomer(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Query query = session.createQuery("select rc from RealCustomer rc where rc.id= :id");
        query.setParameter("id", id);
        Object realCustomer = query.getFirstResult();
        return (RealCustomer) realCustomer;
    }

    public RealCustomer retrieveRealCustomerName(String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Query query = session.createQuery("select rc from RealCustomer rc, Customer c  where rc.id = c.id and c.customerNumber= :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        RealCustomer realCustomer = (RealCustomer) query.getSingleResult();
        return realCustomer;

    }
}
