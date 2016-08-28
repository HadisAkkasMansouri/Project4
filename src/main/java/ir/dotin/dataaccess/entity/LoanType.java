package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LoanType")
public class LoanType {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id", unique = true, nullable = false)
    private int loanTypeId;

    @Column(name = "loan_type_name", unique = true, nullable = false)
    private String loanTypeName;

    @Column(name = "interest_rate", nullable = false)
    private float interestRate;

    @OneToMany
    @JoinColumn(name = "loan_type_id")
    private List<GrantCondition> grantConditions;

    public LoanType(){}

    public LoanType(String loanTypeName, float interestRate){

        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
