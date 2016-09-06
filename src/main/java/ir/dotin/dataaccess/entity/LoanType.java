package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LoanType")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "loan_type_name", unique = true, nullable = false)
    private String loanTypeName;

    @Column(name = "interest_rate", nullable = false)
    private Float interestRate;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "loanTypeId")
    private List<GrantCondition> grantConditions;

    public LoanType() {
    }

    public LoanType(int loanTypeId, String loanTypeName, float interestRate) {
        this.id = loanTypeId;
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
    }

    public LoanType(String loanTypeName, float interestRate) {
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
    }

    public Integer getId() {
        return id;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public void setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
