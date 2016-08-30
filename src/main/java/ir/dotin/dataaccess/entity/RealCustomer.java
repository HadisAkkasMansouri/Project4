package ir.dotin.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "RealCustomer")
public class RealCustomer extends Customer {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "family_name", nullable = false)
    private String familyName;

    @Column(name = "father_name", nullable = false)
    private String fatherName;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "national_code", unique = true, nullable = false)
    private String  nationalCode;

    public RealCustomer(){}

    public RealCustomer(String customerNumber ,  String name, String familyName, String fatherName, String birthDate, String nationalCode){
        super( customerNumber);
        this.name = name;
        this.familyName = familyName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getNationalCode() {
        return nationalCode;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "name ='" + name + '\'' +
                ", family ='" + familyName + '\'' +
                ", customerNumber ='" + getCustomerNumber() + '\'' +
                ", fatherName ='" + fatherName + '\'' +
                ", birthDate ='" + birthDate + '\'' +
                ", nationalCode ='" + nationalCode + '\'' +
                ", id ='" + getId() + '\'' +
                '}';
    }
}
