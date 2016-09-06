package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LegalCustomer;
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


public class LegalCustomerDAO {

    public boolean checkUniqueLegalEconomicCode(String economicCode) throws DuplicateEntranceException {
        Session session = SessionConnection.getSessionConnection().openSession();
        try {
            Query query = session.createQuery("select lc from LegalCustomer lc where lc.economicCode= :economicCode");
            System.out.println(query);
            query.setParameter("economicCode", economicCode);
            Object result = query.getSingleResult();
            if (result != null) {
                throw new DuplicateEntranceException("کد اقتصادی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
            }
        } catch (HibernateException e) {
                e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return true;
    }

    public LegalCustomer addLegalCustomer(String companyName, String economicCode, String registrationDate) throws DuplicateEntranceException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        LegalCustomer legalCustomer = new LegalCustomer();
        try {
            int customerNum = CustomerDAO.retrieveMaxCustomerNumber();
            String customerNumber = String.valueOf(customerNum);
            if (checkUniqueLegalEconomicCode(economicCode)) {
                legalCustomer = new LegalCustomer(customerNumber, companyName, registrationDate, economicCode);
                legalCustomer = (LegalCustomer) session.save(legalCustomer);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return legalCustomer;
    }

    public boolean deleteLegalCustomer(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            if (CustomerDAO.deleteCustomer(id)) {
                Query query = session.createQuery("delete from  LegalCustomer lc where lc.id= :id");
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
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return true;
    }

    public Query buildLegalCustomerQuery(String companyName, String economicCode, String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Query query = null;
        int counter = 1;
        StringBuilder queryString = new StringBuilder("select from LegalCustomer lc, Customer c where lc.id = c.id and ");
        List<String> parameters = new ArrayList<String>();
        if ((customerNumber != null) && (!customerNumber.trim().equals(""))) {
            queryString.append("c.customerNumber= :customerNumber and ");
            parameters.add(customerNumber);
        }
        if ((companyName != null) && (!companyName.trim().equals(""))) {
            queryString.append("lc.companyName= :companyName and ");
            parameters.add(companyName);
        }
        if ((economicCode != null) && (!economicCode.trim().equals(""))) {
            queryString.append("lc.economicCode= :economicCode and ");
            parameters.add(economicCode);
        }
        queryString.append("true");
        try {
            query = session.createQuery(queryString.toString());
            for (String parameter : parameters) {
                query.setParameter(counter, parameter);
                counter++;
            }
            LoggerUtil.getLogger().info("The query of Legal customer has been done successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().info("The query of Legal customer has not been done!");
            e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return query;
    }

    public List<LegalCustomer> searchLegalCustomer(String companyName, String economicCode, String legalCustomerNumber) {

        List<LegalCustomer> result = new ArrayList<LegalCustomer>();
        Session session = SessionConnection.getSessionConnection().openSession();
        try {
            Query query = buildLegalCustomerQuery(companyName, economicCode, legalCustomerNumber);
            List<LegalCustomer> legalCustomers = query.getResultList();
            for (LegalCustomer legalCustomer : legalCustomers) {
                result.add(legalCustomer);
            }
            LoggerUtil.getLogger().info("The retrieval of legal customers have been successfully.");
        } catch (HibernateException e) {
            LoggerUtil.getLogger().info("The retrieval of legal customers have not been!");
            e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
        return result;
    }

    public LegalCustomer updateLegalCustomer(String companyName, String economicCode, String registrationDate, String customerNumber) throws Exception {

        int id = CustomerDAO.retrieveIdByCustomerNumber(customerNumber);
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update LegalCustomer lc set lc.companyName= :companyName, lc.economicCode= :economicCode, lc.registrationDate= : registrationDate" +
                    " where lc.id= :id");
            query.setParameter("companyName", companyName);
            query.setParameter("economicCode", economicCode);
            query.setParameter("registrationDate", registrationDate);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            LoggerUtil.getLogger().info("The legal customer has been updated successfully.");
            return new LegalCustomer(customerNumber, companyName, economicCode, registrationDate);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                LoggerUtil.getLogger().warn("The legal customer has not been updated!");
                e.printStackTrace();
            }
            throw new Exception("عملیات اصلاح موفقیت آمیز نبود!");
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }


    public LegalCustomer getLegalCustomer(int id) throws NotFoundDataException {

        Session session = SessionConnection.getSessionConnection().openSession();
        try {
            Query query = session.createQuery("select lc from LegalCustomer lc where lc.id= :id");
            query.setParameter("id", id);
            Object result = query.getFirstResult();
            LoggerUtil.getLogger().info("The retrieval of legal customer by id has been done successfully.");
            return (LegalCustomer) result;
        }catch (Exception e){
            LoggerUtil.getLogger().warn("The retrieval of legal customer by id has not been done!");
            e.printStackTrace();
            throw new NotFoundDataException("مشتری حقوقی با id مذکور یافت نشد.");
        }finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }
}

