package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LoanFile")

public class LoanFile {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id", unique = true, nullable = false)
    private Integer loanFileId;

    @ManyToOne
    private RealCustomer realCustomer;

    @ManyToOne
    private LoanType loanType;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public Integer getLoanFileId() {
        return loanFileId;
    }

    public RealCustomer getRealCustomer() {
        return realCustomer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public Integer getDuration() {
        return duration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setLoanFileId(Integer loanFileId) {
        this.loanFileId = loanFileId;
    }

    public void setRealCustomer(RealCustomer realCustomer) {
        this.realCustomer = realCustomer;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
