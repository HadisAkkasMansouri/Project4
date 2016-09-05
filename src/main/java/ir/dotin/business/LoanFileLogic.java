package ir.dotin.business;

import ir.dotin.dataaccess.GrantConditionDAO;
import ir.dotin.dataaccess.LoanFileDAO;
import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.dataaccess.entity.LoanFile;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.exception.NotInRangeException;
import ir.dotin.exception.NullRequiredFieldException;

import java.util.List;

public class LoanFileLogic {

    public static boolean validateCustomerNumber(String customerNumber) throws NullRequiredFieldException {

        if (customerNumber.isEmpty()) {
            throw new NullRequiredFieldException("پر کردن فیلد شماره مشتری الزامی است");
        } else {
            return true;
        }
    }

    public static boolean validateLoanFileGrantConditions(LoanFile loanFile, Integer loanTypeId) throws NotFoundDataException, NotInRangeException {

        GrantConditionDAO grantConditionDAO = new GrantConditionDAO();
        List<GrantCondition> grantConditions = grantConditionDAO.retrieveGrantConditionsByLoanTypeId(loanTypeId);
        for (GrantCondition grantCondition : grantConditions) {
            if (loanFile.getDuration() > grantCondition.getMaxDuration() || loanFile.getDuration() < grantCondition.getMinDuration()) {
                throw new NotInRangeException("مدت زمان وارد شده٬ خارج از محدوده مدت زمان قرارداد می باشد لطفا مجددا تلاش نمایید.");
            } else if ((loanFile.getAmount().compareTo(grantCondition.getMaxAmount()) <= 0) || (loanFile.getAmount().compareTo(grantCondition.getMinAmount()) <= 0)) {
                throw new NotInRangeException("مبلغ وارد شده٬ خارج از محدوده مبلغ قرارداد می باشد لطفا مجددا تلاش نمایید.");
            }
        }
        return true;
    }

    public static void insertLoanFile(String customerNumber, Integer loanTypeId, LoanFile loanFile) throws NotFoundDataException, NotInRangeException {

        LoanFileDAO loanFileDAO = new LoanFileDAO();
        if(validateLoanFileGrantConditions(loanFile, loanTypeId)){
          loanFileDAO.insertLoanFile(customerNumber, loanTypeId, loanFile);
        }
    }
}
