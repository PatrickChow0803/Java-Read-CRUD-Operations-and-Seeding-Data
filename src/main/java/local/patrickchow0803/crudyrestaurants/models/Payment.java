package local.patrickchow0803.crudyrestaurants.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payment {

    @Id // Makes this a primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates the values automatically
    private long paymentid;

    //Makes sure that all payment types have a name and are unique
    @Column(nullable = false,
            unique = true)
    private String type;

    @ManyToMany(mappedBy = "payments")
    private List<Restaurant> restaurants = new ArrayList<>();

    public Payment(){
        // Spring Data JPA Requires this default constructor
    }

    public Payment(String type) {
        this.type = type;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
