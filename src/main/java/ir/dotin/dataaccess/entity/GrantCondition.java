package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Grant_Condition")
public class GrantCondition {

    @Id
    @ManyToOne
    @JoinColumn(name = "id", unique = true, nullable = false)
    private int grantConditionId;

    @Column(name = "Grant_Condition_Name", nullable = false)
    private String grantConditionName;

    @Column(name = "Minimum_Duration", nullable = false)
    private int minDuration;

    @Column(name = "Maximum_Duration", nullable = false)
    private int maxDuration;

    @Column(name = "Minimum_Amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "Maximum_Amount", nullable = false)
    private BigDecimal maxAmount;

    @Column(name = "Loan_Type_Id", nullable = false, unique = true)
    private int loanTypeId;

    public int getGrantConditionId() {
        return grantConditionId;
    }

    public String getGrantConditionName() {
        return grantConditionName;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public int getLoanTypeId() {
        return loanTypeId;
    }

    public void setGrantConditionId(int grantConditionId) {
        this.grantConditionId = grantConditionId;
    }

    public void setGrantConditionName(String grantConditionName) {
        this.grantConditionName = grantConditionName;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }
}
