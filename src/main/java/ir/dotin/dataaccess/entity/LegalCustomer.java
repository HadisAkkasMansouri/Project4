package ir.dotin.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "LegalCustomer")
public class LegalCustomer extends Customer {

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "registration_date", nullable = false)
    private String registrationDate;

    @Column(name = "economic_code", unique = true, nullable = false)
    private String economicCode;

    public LegalCustomer(){}

    public LegalCustomer(String  customerNumber, String companyName, String registrationDate, String economicCode){
        super(customerNumber);
        this.companyName = companyName;
        this.registrationDate = registrationDate;
        this.economicCode = economicCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "name ='" + companyName + '\'' +
                ", registrationDate ='" + registrationDate + '\'' +
                ", economicId ='" + economicCode + '\'' +
                ", id ='" + getId() + '\'' +
                '}';
    }
}