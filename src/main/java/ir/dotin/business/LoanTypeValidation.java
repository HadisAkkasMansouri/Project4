package ir.dotin.business;

import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;

public class LoanTypeValidation {

    public static boolean validateLoanTypeFields(String loanTypeName, Float interestRate) throws NullRequiredFieldException, InvalidEntranceException {

        if (loanTypeName.isEmpty()) {
            throw new NullRequiredFieldException("پر کردن فیلد نام نوع تسهیلات الزامی است");
        }
        if (interestRate == null) {
            throw new NullRequiredFieldException("پر کردن فیلد نرخ سود الزامی است");
        }
        if (interestRate >= 100) {
            throw new InvalidEntranceException("نرخ سود باید کمتر از ۱۰۰ درصد باشد");
        }
        return true;
    }
}
