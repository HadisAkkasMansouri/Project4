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

    RealCustomer realCustomer = new RealCustomer();

    public boolean checkUniqueRealNationalCode(String nationalCode) throws DuplicateEntranceException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select rc.id from RealCustomer rc where rc.nationalCode= :nationalCode");
            System.out.println(query);
            query.setParameter("nationalCode", nationalCode);
            Object result = query.getSingleResult();
            transaction.commit();
            if (result != null) {
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
        try{
            int customerNum = CustomerDAO.retrieveMaxCustomerNumber();
            String customerNumber = String.valueOf(customerNum);
            int id = CustomerDAO.addCustomer(customerNumber);
            if (checkUniqueRealNationalCode(nationalCode)) {
                realCustomer = new RealCustomer(id, name, familyName, fatherName, birthDate, nationalCode);
                realCustomer = (RealCustomer) session.save(realCustomer);
                realCustomer.setCustomerNumber(customerNumber);
                transaction.commit();
            }
        }catch (HibernateException e) {
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
        try{
            if(CustomerDAO.deleteCustomer(id)){
                Query query = session.createQuery("delete from RealCustomer rc where rc.id= :id");
                System.out.println(query);
                query.setParameter("id", id);
                query.executeUpdate();
                transaction.commit();
            }
        }catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
                e.printStackTrace();
                return false;
            }
        }finally {
            session.close();
        }
        return true;
    }


    public Query buildRealCustomerQuery(String name, String familyName, String nationalCode, String customerNumber) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        Query query = null;
        int counter = 1;
        StringBuilder queryString = new StringBuilder("from RealCustomer rc, Customer c where rc.id = c.id and ");
        List<String> parameters = new ArrayList<String>();
        if((customerNumber != null) && (!customerNumber.trim().equals(""))){
            queryString.append("c.customer.customerNumber= :customerNumber and ");
            parameters.add(customerNumber);
        }
        if((name != null) && (!name.trim().equals(""))){
            queryString.append("rc.name= :name and");
            parameters.add(name);
        }
        if((familyName != null) && (!familyName.trim().equals(""))){
            queryString.append("rc.familyName= :familyName and");
            parameters.add(familyName);
        }if((nationalCode != null) && (!nationalCode.trim().equals(""))){
            queryString.append("rc.nationalCode= :nationalCode and");
            parameters.add(nationalCode);
        }
        queryString.append("true");
        try{
            query = session.createQuery(queryString.toString());
            for(String parameter : parameters){
                query.setParameter(counter, parameter);
                counter++;
            }
        }catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
        }
        return query;
    }

    public List<RealCustomer> searchRealCustomer(String name, String familyName, String nationalCode, String customerNumber) {

        List<RealCustomer> realCustomers = new ArrayList<RealCustomer>();
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try{
            Query query = buildRealCustomerQuery(name, familyName, nationalCode, customerNumber);
            List result = query.getResultList();
            transaction.commit();
            while (result != null){
                realCustomer.getId();
                realCustomer.getName();
                realCustomer.getFamilyName();
                realCustomer.getFatherName();
                realCustomer.getBirthDate();
                realCustomer.getBirthDate();
                realCustomer.getCustomerNumber();
                realCustomers.add(realCustomer);
            }
        }catch(HibernateException e){
            if(transaction != null){
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
        }
        return realCustomers;
    }

    public RealCustomer updateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode, String customerNumber){

        int id = CustomerDAO.retrieveIdByCustomerNumber(customerNumber);
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try{
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

            realCustomer.getId();
            realCustomer.getName();
            realCustomer.getFamilyName();
            realCustomer.getFatherName();
            realCustomer.getBirthDate();
            realCustomer.getNationalCode();
            realCustomer.getCustomerNumber();
        }catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
        }
        return realCustomer;
    }

    public RealCustomer getRealCustomer(int id){

        String customerNumber = CustomerDAO.retrieveCustomerNumberById(id);
        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try{
            Query query = session.createQuery("from RealCustomer rc where rc.id= :id");
            query.setParameter("id", id);
            Object result = query.getFirstResult();
            realCustomer = (RealCustomer) result;
            transaction.commit();
            while (result != null){
                realCustomer.getId();
                realCustomer.getName();
                realCustomer.getFamilyName();
                realCustomer.getFatherName();
                realCustomer.getBirthDate();
                realCustomer.getNationalCode();
                realCustomer.getCustomerNumber();
            }
        }catch (HibernateException e){
            if(transaction != null){
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
        }
        return realCustomer;
    }
}
