package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GrantConditionDAO {

    public void insertGrantConditionByLoanType(LoanType loanType, List<GrantCondition> grantConditions) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = 0;
        try {
            transaction = session.beginTransaction();
            session.save(loanType);
            for (GrantCondition grantCondition : grantConditions) {
                grantCondition.setLoanTypeId(loanType.getLoanTypeId());
                session.save(grantCondition);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
    }
}
