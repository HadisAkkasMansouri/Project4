package ir.dotin.dataaccess;

import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.utility.LoggerUtil;
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
            Query query = session.createQuery("select loan from LoanType loan where loan.id = :loanTypeId");
            query.setParameter("loanTypeId", loanTypeId);
            loanType = (LoanType) query.getSingleResult();
            LoggerUtil.getLogger().info("The retrieval of LoanType has been done successfully.");
            return loanType;
        } catch (HibernateException e) {
            LoggerUtil.getLogger().warn("The retrieval of LoanType has not been done!");
            e.printStackTrace();
            throw new NotFoundDataException("یافت نشد!" + loanTypeId + "نوع تسهیلاتی با شماره");
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }

    public static List<LoanType> retrieveLoanTypes() throws NotFoundDataException {
        Session session = SessionConnection.getSessionConnection().openSession();
        List<LoanType> loanTypes = new ArrayList<LoanType>();
        try {
            Query query = session.createQuery("select loanType from LoanType loanType");
            loanTypes = query.getResultList();
            LoggerUtil.getLogger().info("The retrieval of LoanTypes has been done successfully.");
            return loanTypes;
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().warn("The retrieval of LoanTypes has not been done!");
            e.printStackTrace();
            throw new NotFoundDataException("هیچ نوع تسهیلاتی یافت نشد");
        } finally {
            session.close();
            LoggerUtil.getLogger().info("Session is closed!");
        }
    }
}

