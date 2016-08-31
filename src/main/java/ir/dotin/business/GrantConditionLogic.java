package ir.dotin.business;

import ir.dotin.dataaccess.GrantConditionDAO;
import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NotInRangeException;
import ir.dotin.exception.NullRequiredFieldException;
import java.util.List;

public class GrantConditionLogic {

    public static boolean validateGrantCondition(List<GrantCondition> grantConditions) throws NullRequiredFieldException, NotInRangeException {

        for (GrantCondition grantCondition : grantConditions) {

            if (grantCondition.getGrantConditionName() == null) {
                throw new NullRequiredFieldException("وارد نمودن فیلد نام شرط اعطا الزامی است");
            }
            if (grantCondition.getMinAmount() == null) {
                throw new NullRequiredFieldException("وارد نمودن فیلد حداقل مبلغ قرارداد الزامی است");
            }
            if (grantCondition.getMaxAmount() == null) {
                throw new NullRequiredFieldException("وارد نمودن فیلد حداکثر مبلغ قرارداد الزامی است");
            }
            if (grantCondition.getMinDuration() == 0) {
                throw new NullRequiredFieldException("وارد نمودن فیلد حداقل مدت قرارداد الزامی است");
            }
            if (grantCondition.getMaxDuration() == 0) {
                throw new NullRequiredFieldException("وارد نمودن فیلد حداکثر مدت قرارداد الزامی است");
            }
            if (grantCondition.getMinDuration() > grantCondition.getMaxDuration()){
                throw new NotInRangeException("حداکثر مدت قرداد باید از حداقل مدت قرداد بزرگتر باشد");
            }
            if ((grantCondition.getMinAmount().compareTo(grantCondition.getMaxAmount())) <= 0){
                throw new NotInRangeException("حداکثر مبلغ قرداد باید از حداقل مبلغ قرداد بزرگتر باشد");
            }
        }
        return true;
    }

    public static void insertGrandConditionByLoanType(LoanType loanType, List<GrantCondition> grantConditions) throws NullRequiredFieldException, NotInRangeException {

        if(validateGrantCondition(grantConditions)){
            GrantConditionDAO grantConditionDAO = new GrantConditionDAO();
            grantConditionDAO.insertGrantConditionByLoanType(loanType, grantConditions);
        }
    }
}
