package ir.dotin.business;

import ir.dotin.exception.NullRequiredFieldException;

public class LoanFileLogic {

    public static boolean validateCustomerNumber(String customerNumber) throws NullRequiredFieldException {

        if (customerNumber.isEmpty()){
            throw new NullRequiredFieldException("پر کردن فیلد شماره مشتری الزامی است");
        }else {
            return true;
        }
    }
}
