package ir.dotin.business;

import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.exception.NullRequiredFieldException;

import java.util.List;

public class RealCustomerLogic {

    public static boolean validateAddRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) throws NullRequiredFieldException, InvalidEntranceException, DuplicateEntranceException {

        if (name.isEmpty()) {
            throw new NullRequiredFieldException("وارد نمودن فیلد نام الزامی است");
        }
        if (familyName.isEmpty()) {
            throw new NullRequiredFieldException("وارد نمودن نام خانوادگی الزامی است");
        }
        if (fatherName.isEmpty()) {
            throw new NullRequiredFieldException("وارد نمودن نام پدر الزامی است");
        }
        if (birthDate.isEmpty()) {
            throw new NullRequiredFieldException("وارد نمودن تاریخ تولد الزامی است");
        }

        if (nationalCode.isEmpty()) {
            throw new NullRequiredFieldException("وارد نمودن کد ملی الزامی است");
        }

        if (nationalCode.length() != 10) {
            throw new InvalidEntranceException("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }
        return true;

    }

    public static RealCustomer insertRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode) throws DuplicateEntranceException {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        RealCustomer realCustomer = realCustomerDAO.addRealCustomer(name, familyName, fatherName, birthDate, nationalCode);
        return realCustomer;
    }

    public static RealCustomer validateUpdateRealCustomer(String name, String familyName, String fatherName, String birthDate, String nationalCode, String customerNumber) throws Exception {


        if (nationalCode.length() != 10) {
            throw new InvalidEntranceException("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
        }

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        RealCustomer realCustomer = realCustomerDAO.updateRealCustomer(name, familyName, fatherName, birthDate, nationalCode, customerNumber);
        return realCustomer;

    }

    public static boolean deleteRealCustomer(int id) {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        if (realCustomerDAO.deleteRealCustomer(id)) {
            return true;
        } else {
            return false;
        }
    }

    public static List<RealCustomer> searchRealCustomer(String name, String familyName, String nationalCode, String customerNumber) {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        List<RealCustomer> realCustomers = realCustomerDAO.searchRealCustomer(name, familyName, nationalCode, customerNumber);
        return realCustomers;
    }

    public static RealCustomer getRealCustomer(int id) throws Exception {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        RealCustomer realCustomer = realCustomerDAO.getRealCustomer(id);
        return realCustomer;
    }

    public static RealCustomer getRealCustomerInfo(String customerNumber) throws Exception {

        RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
        RealCustomer realCustomer = realCustomerDAO.retrieveRealCustomerName(customerNumber);
        return realCustomer;
    }
}