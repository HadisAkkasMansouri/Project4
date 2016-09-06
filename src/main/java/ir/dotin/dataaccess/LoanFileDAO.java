package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LoanFile;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.LoggerUtil;
import ir.dotin.utility.SessionConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoanFileDAO {

    public void saveLoanFile(LoanFile loanFile, LoanType loanType, RealCustomer realCustomer) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            loanFile.setLoanType(loanType);
            loanFile.setRealCustomer(realCustomer);
            session.save(loanFile);
            session.getTransaction().commit();
            transaction.commit();
            LoggerUtil.getLogger().info("The LoanFile has been saved successfully.");
        } catch (Exception e) {
            LoggerUtil.getLogger().error("The LoanFile has not been saved!");
            e.printStackTrace();
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }

    public void insertLoanFile(String customerNumber, Integer loanTypeId, LoanFile loanFile) throws NotFoundDataException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction;
        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        LoanType loanType;
        try {
            transaction = session.beginTransaction();
            loanType = LoanTypeDAO.retrieveLoanType(loanTypeId);
            loanFile.setLoanType(loanType);
            RealCustomer realCustomer = realCustomerDAO.retrieveRealCustomerName(customerNumber);
            loanFile.setRealCustomer(realCustomer);
            saveLoanFile(loanFile, loanType, realCustomer);
            transaction.commit();
            LoggerUtil.getLogger().info("The LoanFile has been inserted successfully.");
        } catch (Exception e) {
            LoggerUtil.getLogger().error("The LoanFile has not been inserted!");
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }
}
