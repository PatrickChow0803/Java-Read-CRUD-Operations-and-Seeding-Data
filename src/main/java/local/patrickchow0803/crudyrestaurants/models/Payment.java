package local.patrickchow0803.crudyrestaurants.models;

import javax.persistence.*;

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
}
