package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class GrantDonditionDAO {

    public int addGrantDondition(String grantConditionName, int minDuration, int maxDuration, BigDecimal minAmount, BigDecimal maxAmount){

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        int id = 0;
        try{
            transaction = session.beginTransaction();
            GrantCondition grantCondition = new GrantCondition(grantConditionName, minDuration, maxDuration, minAmount, maxAmount);
            transaction.commit();
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
