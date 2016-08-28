package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoanTypeDAO {

    public int addLoanType(String loanTypeName, float interestRate) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = 0;
        try {
            transaction = session.beginTransaction();
            LoanType loanType = new LoanType(loanTypeName, interestRate);
            id = (int) session.save(loanType);
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

