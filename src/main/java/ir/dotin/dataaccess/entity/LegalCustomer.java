package ir.dotin.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "LegalCustomer")
//@AttributeOverrides({
//        @AttributeOverride(name = "id", column = @Column(name = "id"))
//})
public class LegalCustomer extends Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
    @PrimaryKeyJoinColumn(name="id")
    private int id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "registration_date", nullable = false)
    private String registrationDate;

    @Column(name = "economic_code", unique = true, nullable = false)
    private String economicCode;

    public LegalCustomer(){}

    public LegalCustomer(int id, String companyName, String registrationDate, String economicCode){
        this.id = id;
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

    @Override
    public int getId() {
        return id;
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
    public void setId(int id) {
        super.setId(id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "name ='" + companyName + '\'' +
                ", registrationDate ='" + registrationDate + '\'' +
                ", economicId ='" + economicCode + '\'' +
                ", id ='" + id + '\'' +
                '}';
    }
}