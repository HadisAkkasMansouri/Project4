package ir.dotin.business;

import ir.dotin.dataaccess.GrantConditionDAO;
import ir.dotin.dataaccess.LoanFileDAO;
import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.dataaccess.entity.LoanFile;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.exception.NotInRangeException;
import ir.dotin.exception.NullRequiredFieldException;
import ir.dotin.utility.SessionConnection;
import org.hibernate.Session;

import java.util.List;

public class LoanFileLogic {

    public static boolean validateCustomerNumber(String customerNumber) throws NullRequiredFieldException {

        if (customerNumber.isEmpty()) {
            throw new NullRequiredFieldException("پر کردن فیلد شماره مشتری الزامی است");
        } else {
            return true;
        }
    }

    public static void validateLoanFileGrantConditions(String customerNumber, LoanFile loanFile, Integer loanTypeId) throws NotFoundDataException, NotInRangeException {

        Session session = SessionConnection.getSessionConnection().openSession();
        try{
            GrantConditionDAO grantConditionDAO = new GrantConditionDAO();
            List<GrantCondition> grantConditions = grantConditionDAO.retrieveGrantConditionsByLoanTypeId(loanTypeId);
            boolean match = false;
            for (GrantCondition grantCondition : grantConditions) {
                if ((loanFile.getDuration() < grantCondition.getMaxDuration()) && (loanFile.getDuration() > grantCondition.getMinDuration())) {
                    if ((loanFile.getAmount().compareTo(grantCondition.getMaxAmount()) >= 0) && (loanFile.getAmount().compareTo(grantCondition.getMinAmount()) >= 0)) {
                        match = true;
                        break;
                    }
                }
            }
            if (match) {
                LoanFileDAO loanFileDAO = new LoanFileDAO();
                loanFileDAO.insertLoanFile(customerNumber, loanTypeId, loanFile);
            } else {
                throw new NotInRangeException("مقادیر وارد شده٬ در هیچ یک از شرایط اعطا صدق نمی کند٬ لطفا مجددا تلاش نمایید");
            }
        }finally {
            session.close();
        }

    }
}
