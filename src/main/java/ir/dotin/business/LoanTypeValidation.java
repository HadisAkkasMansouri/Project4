package ir.dotin.business;

import ir.dotin.exception.NullRequiredFieldException;

public class LoanTypeValidation {

    public boolean validateLoanTypeFields(String loanTypeName, Float interestRate) throws NullRequiredFieldException {

        if (loanTypeName.isEmpty()){
            throw new NullRequiredFieldException("پر کردن فیلد نام نوع تسهیلات الزامی است");
        }
        if (interestRate == null){
            throw new NullRequiredFieldException("پر کردن فیلد نرخ سود الزامی است");
        }
        return true;
    }
}
