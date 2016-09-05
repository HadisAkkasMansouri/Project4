package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LoanFile;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoanFileDAO {

    public void saveLoanFile(LoanFile loanFile, LoanType loanType, RealCustomer realCustomer){

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction;
        try{
            transaction = session.beginTransaction();
            loanFile.setLoanType(loanType);
            loanFile.setRealCustomer(realCustomer);
            session.save(loanFile);
            session.getTransaction().commit();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void insertLoanFile(String customerNumber, Integer loanTypeId, LoanFile loanFile) throws NotFoundDataException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        LoanType loanType;
        loanType = LoanTypeDAO.retrieveLoanType(loanTypeId);
        loanFile.setLoanType(loanType);
        RealCustomer realCustomer = realCustomerDAO.retrieveRealCustomerName(customerNumber);
        loanFile.setRealCustomer(realCustomer);
        saveLoanFile(loanFile, loanType, realCustomer);
    }
}
