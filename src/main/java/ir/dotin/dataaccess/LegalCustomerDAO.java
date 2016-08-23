package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LegalCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class LegalCustomerDAO {

    LegalCustomer legalCustomer = new LegalCustomer();

    public boolean checkUniqueLegalEconomicCode(String economicCode) throws DuplicateEntranceException {
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            Query query = session.createQuery("from LegalCustomer lc where lc.economicCode= :economicCode");
            System.out.println(query);
            query.setParameter("economicCode", economicCode);
            Object result = query.getSingleResult();
            transaction.commit();
            if (result != null) {
                throw new DuplicateEntranceException("کد اقتصادی وارد شده یکتا نیست٬ لطفا مجددا تلاش نمایید");
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

    public LegalCustomer addLegalCustomer(String companyName, String economicCode, String registrationDate) throws DuplicateEntranceException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            int customerNum = CustomerDAO.retrieveMaxCustomerNumber();
            String customerNumber = String.valueOf(customerNum);
            int id = CustomerDAO.addCustomer(customerNumber);
            if (checkUniqueLegalEconomicCode(economicCode)) {
                legalCustomer = new LegalCustomer(id, companyName, registrationDate, economicCode);
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
        }
        return legalCustomer;
    }

    public boolean deleteLegalCustomer(int id) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            if (CustomerDAO.deleteCustomer(id)) {
                Query query = session.createQuery("delete from  LegalCustomer lc where id= :id");
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

    public Query buildLegalCustomerQuery(String companyName, String economicCode, String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        Query query = null;
        int counter = 1;
        StringBuilder queryString = new StringBuilder("select from LegalCustomer lc, Customer c where lc.id = c.id and ");
        List<String> parameters = new ArrayList<String>();
        if ((customerNumber != null) && (!customerNumber.trim().equals(""))) {
            queryString.append("c.customer.customerNumber= :customerNumber and ");
            parameters.add(customerNumber);
        }
        if ((companyName != null) && (!companyName.trim().equals(""))) {
            queryString.append("lc.companyName= :companyName and");
            parameters.add(companyName);
        }
        if ((economicCode != null) && (!economicCode.trim().equals(""))) {
            queryString.append("lc.economicCode= :economicCode and");
            parameters.add(economicCode);
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

    public List<LegalCustomer> searchLegalCustomer(String companyName, String economicCode, String legalCustomerNumber) {

        List<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            Query query = buildLegalCustomerQuery(companyName, economicCode, legalCustomerNumber);
            List result = query.getResultList();
            transaction.commit();
            while (result != null) {
//                legalCustomer.setId(results.getInt("ID"));
//                legalCustomer.setCustomerNumber(CustomerDAO.retrieveCustomerNumberById(results.getInt("ID")));
//                legalCustomer.setCompanyName(results.getString("COMPANY_NAME"));
//                legalCustomer.setEconomicCode(results.getString("ECONOMIC_CODE"));
//                legalCustomer.setRegistrationDate(results.getString("REGISTRATION_DATE"));
                legalCustomers.add(legalCustomer);
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return legalCustomers;
    }

    public LegalCustomer updateLegalCustomer(String companyName, String economicCode, String registrationDate, String customerNumber){

        int id = CustomerDAO.retrieveIdByCustomerNumber(customerNumber);
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try{
            Query query = session.createQuery("update LegalCustomer lc set lc.companyName= :companyName, lc.economicCode= :economicCode, lc.registrationDate= : registrationDate" +
                    " where lc.id= :id");
            query.setParameter("companyName", companyName);
            query.setParameter("economicCode", economicCode);
            query.setParameter("registrationDate", registrationDate);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();

            legalCustomer.setId(id);
            legalCustomer.setCompanyName(companyName);
            legalCustomer.setEconomicCode(economicCode);
            legalCustomer.setRegistrationDate(registrationDate);
            legalCustomer.setCustomerNumber(customerNumber);
        }catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
        }
        return legalCustomer;
    }


    public LegalCustomer getLegalCustomer(int id) {

        String customerNumber = CustomerDAO.retrieveCustomerNumberById(id);
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            Query query = session.createQuery("select from LegalCustomer lc where id= :id");
            query.setParameter("id", id);
            Object result = query.getFirstResult();
            transaction.commit();
//            legalCustomer.setId(result.getInt("ID"));
//            legalCustomer.setCompanyName(result.getString("COMPANY_NAME"));
//            legalCustomer.setEconomicCode(result.getString("ECONOMIC_CODE"));
//            legalCustomer.setRegistrationDate(result.getString("REGISTRATION_DATE"));
            legalCustomer.setCustomerNumber(customerNumber);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return legalCustomer;
    }
}

