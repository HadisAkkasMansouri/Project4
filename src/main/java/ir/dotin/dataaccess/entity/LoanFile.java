package ir.dotin.dataaccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Loan_File")

public class LoanFile {

    @Id
    @ManyToOne
    @JoinColumn(name = "id", unique = true, nullable = false)
    private int loanFileId;


    private RealCustomer realCustomer;


    private LoanType loanType;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public int getLoanFileId() {
        return loanFileId;
    }

    public RealCustomer getRealCustomer() {
        return realCustomer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public int getDuration() {
        return duration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setLoanFileId(int loanFileId) {
        this.loanFileId = loanFileId;
    }

    public void setRealCustomer(RealCustomer realCustomer) {
        this.realCustomer = realCustomer;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
