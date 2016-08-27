package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Loan_Type")
public class LoanType {

    @Id
    @OneToMany
    @JoinColumn(name = "id", unique = true, nullable = false)
    private int loanTypeId;

    @Column(name = "Loan_Type_name", unique = true, nullable = false)
    private String loanTypeName;

    @Column(name = "Interest_Rate", nullable = false)
    private float interestRate;

    @Column(name = "Grant_Conditions", nullable = false)
    private List<GrantCondition> grantConditionList;

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public List<GrantCondition> getGrantConditionList() {
        return grantConditionList;
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

    public void setGrantConditionList(List<GrantCondition> grantConditionList) {
        this.grantConditionList = grantConditionList;
    }
}
