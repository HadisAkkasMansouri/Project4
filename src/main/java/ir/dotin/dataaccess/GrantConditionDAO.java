package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.List;

public class GrantConditionDAO {

    public void insertGrantConditionByLoanType(LoanType loanType, List<GrantCondition> grantConditions) {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            loanType.setGrantConditions(grantConditions);
            session.save(loanType);
            for (GrantCondition grantCondition : loanType.getGrantConditions()) {
                session.save(grantCondition);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
    }

    public List<GrantCondition> retrieveGrantConditionsByLoanTypeId(Integer loanTypeId) throws NotFoundDataException {

        List<GrantCondition> grantConditions;
        Session session = SessionConnection.getSessionConnection().openSession();
        try {
            Query query = session.createQuery("select gc from GrantCondition gc where gc.loanTypeId= :loanTypeId");
            query.setParameter("loanTypeId", loanTypeId);
            grantConditions = query.getResultList();
            return grantConditions;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundDataException("بازیابی شروط اعطا با خطا مواجه شد!");
        } finally {
            session.close();
        }
    }
}
