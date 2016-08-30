package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class LoanTypeDAO {

    public static LoanType retrieveLoanType(int loanTypeId) throws NotFoundDataException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        LoanType loanType = null;
        try {
            Query query = session.createQuery("from Loantype loan where loan.loanTypeId= :loanTypeId");
            query.setParameter("loanTypeId", loanTypeId);
            int result = (int) query.getSingleResult();
            if (result != 0) {
                loanType = session.get(LoanType.class, loanTypeId);
            } else {
                throw new NotFoundDataException("یافت نشد!" + loanTypeId + "نوع تسهیلاتی با شماره");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return loanType;
    }
}

