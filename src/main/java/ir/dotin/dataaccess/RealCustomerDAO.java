package ir.dotin.dataaccess;

import com.sun.org.apache.xpath.internal.operations.String;
import ir.dotin.dataaccess.entity.Customer;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealCustomerDAO extends Customer {

    public boolean checkUniqueRealNationalCode(String nationalCode) throws DuplicateEntranceException {

        Session session = SessionConnection.getSessionConnection().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select rc.id from RealCustomer rc where rc.nationalCode=:nc");
            System.out.println(query);
            query.setParameter("nc", nationalCode);
            Object singleResult = query.getSingleResult();
            transaction.commit();
            if (singleResult!=null) {
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


    }

    public boolean deleteRealCustomer(int id) {


        return true;
    }

    public PreparedStatement searchRealCustomerPreparedStatement(String name, String familyName, String nationalCode, String customerNumber) {


    }

    public ArrayList<RealCustomer> searchRealCustomer(String name, String familyName, String nationalCode, String customerNumber) {

    }

    public RealCustomer updateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode, String customerNumber) throws DuplicateEntranceException {


    }

    public RealCustomer getRealCustomer(int id) throws SQLException {


    }
}
