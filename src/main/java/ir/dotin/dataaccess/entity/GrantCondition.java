package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GrantCondition")
public class GrantCondition {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id", unique = true, nullable = false)
    private int grantConditionId;

    @Column(name = "grant_condition_name", nullable = false)
    private String grantConditionName;

    @Column(name = "minimum_duration", nullable = false)
    private int minDuration;

    @Column(name = "maximum_duration", nullable = false)
    private int maxDuration;

    @Column(name = "minimum_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "maximum_amount", nullable = false)
    private BigDecimal maxAmount;

    private int loanTypeId;

    public GrantCondition(){}

    public GrantCondition(String grantConditionName, int minDuration, int maxDuration, BigDecimal minAmount, BigDecimal maxAmount){

        this.grantConditionName = grantConditionName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
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
