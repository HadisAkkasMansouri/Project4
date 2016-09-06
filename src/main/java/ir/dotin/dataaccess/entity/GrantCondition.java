package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GrantCondition")
public class GrantCondition {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id", unique = true, nullable = false)
    private Integer grantConditionId;

    @Column(name = "grant_condition_name", nullable = false)
    private String grantConditionName;

    @Column(name = "minimum_duration", nullable = false)
    private Integer minDuration;

    @Column(name = "maximum_duration", nullable = false)
    private Integer maxDuration;

    @Column(name = "minimum_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "maximum_amount", nullable = false)
    private BigDecimal maxAmount;

    @Column(name = "loan_type_id")
    private Integer loanTypeId;

    public GrantCondition(){}

    public GrantCondition(String grantConditionName, int minDuration, int maxDuration, BigDecimal minAmount, BigDecimal maxAmount){

        this.grantConditionName = grantConditionName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public Integer getGrantConditionId() {
        return grantConditionId;
    }

    public String getGrantConditionName() {
        return grantConditionName;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public Integer getLoanTypeId() {
        return loanTypeId;
    }

    public void setGrantConditionId(Integer grantConditionId) {
        this.grantConditionId = grantConditionId;
    }

    public void setGrantConditionName(String grantConditionName) {
        this.grantConditionName = grantConditionName;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setLoanTypeId(Integer loanTypeId) {
        this.loanTypeId = loanTypeId;
    }
}
