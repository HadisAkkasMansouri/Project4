package ir.dotin.business;

import ir.dotin.dataaccess.LegalCustomerDAO;
import ir.dotin.dataaccess.entity.LegalCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.exception.NullRequiredFieldException;
import java.sql.SQLException;
import java.util.List;

public class LegalCustomerLogic {

    public static LegalCustomer validateAddLegalCustomer(String companyName, String economicCode, String registrationDate) throws NullRequiredFieldException, InvalidEntranceException, DuplicateEntranceException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        if (!companyName.isEmpty()) {

            if (!economicCode.isEmpty()) {

                if (!registrationDate.isEmpty()) {

                    if (economicCode.length() == 10) {
                        LegalCustomer legalCustomer = legalCustomerDAO.addLegalCustomer(companyName, economicCode, registrationDate);
                        return legalCustomer;
                    } else {
                        throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
                    }
                } else {
                    throw new NullRequiredFieldException("وارد نمودن تاریخ ثبت شرکت الزامی است");
                }
            } else {
                throw new NullRequiredFieldException("وارد نمودن کد اقتصادی شرکت الزامی است");
            }
        } else {
            throw new NullRequiredFieldException("وارد نمودن نام شرکت الزامی است");
        }
    }

    public static LegalCustomer validateUpdateLegalCustomer(String companyName, String economicCode, String registrationDate, String customerNumber) throws Exception {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        if (economicCode.length() == 10) {
            LegalCustomer legalCustomer = legalCustomerDAO.updateLegalCustomer(companyName, economicCode, registrationDate, customerNumber);
            return legalCustomer;
        } else {
            throw new InvalidEntranceException("کد اقتصادی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
    }

    public static boolean deleteLegalCustomer(int id) {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        if (legalCustomerDAO.deleteLegalCustomer(id)) {
            return true;
        } else {
            return false;
        }
    }

    public static List<LegalCustomer> searchLegalCustomer(String companyName, String economicCode, String legalCustomerNumber) {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        List<LegalCustomer> legalCustomers = legalCustomerDAO.searchLegalCustomer(companyName, economicCode, legalCustomerNumber);
        return legalCustomers;
    }

    public static LegalCustomer getLegalCustomer(int id) throws SQLException, NotFoundDataException {

        LegalCustomerDAO legalCustomerDAO = new LegalCustomerDAO();
        LegalCustomer legalCustomer =  legalCustomerDAO.getLegalCustomer(id);
        return legalCustomer;
    }
}
