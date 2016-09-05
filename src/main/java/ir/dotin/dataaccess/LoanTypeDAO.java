package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LoanTypeDAO {

    public static LoanType retrieveLoanType(int loanTypeId) throws NotFoundDataException {

        Session session = SessionConnection.getSessionConnection().openSession();
        LoanType loanType = null;
        try {
            Query query = session.createQuery("select loan from LoanType loan where loan.loanTypeId= :loanTypeId");
            query.setParameter("loanTypeId", loanTypeId);
            loanType = (LoanType) query.getSingleResult();
            return loanType;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new NotFoundDataException("یافت نشد!" + loanTypeId + "نوع تسهیلاتی با شماره");
        } finally {
            session.close();
        }
    }

    public static List<LoanType> retrieveLoanTypes() throws NotFoundDataException {
        Session session = SessionConnection.getSessionConnection().openSession();
        List<LoanType> loanTypes = new ArrayList<LoanType>();
        try {
            Query query = session.createQuery("select loanType from LoanType loanType");
            loanTypes = query.getResultList();
            return loanTypes;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new NotFoundDataException("هیچ نوع تسهیلاتی یافت نشد");
        } finally {
            session.close();
        }
    }
}

