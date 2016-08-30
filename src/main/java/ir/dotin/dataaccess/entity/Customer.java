package ir.dotin.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@Inheritance(strategy=InheritanceType.JOINED)
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id")
    private int id;

    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;

    public Customer(){}
    public Customer(String customerNumber){
        this.customerNumber = customerNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerId) {
        this.customerNumber = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
