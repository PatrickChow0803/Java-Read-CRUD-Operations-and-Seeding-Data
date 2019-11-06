package local.patrickchow0803.crudyrestaurants.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Tells Spring to use this class as a table
@Entity

//Names the table restaurants
@Table(name = "restaurants")
public class Restaurant {
    @Id // Makes this a primary key
    @GeneratedValue(strategy = GenerationType.AUTO)// Generates the values automatically
    private long restaurantid;

    //Makes sure that all restaurants have a name and are unique
    @Column(unique = true,
            nullable = false)
    private String name;

    private String address;
    private String city;
    private String state;
    private String telephone;
    private int seatcapacity;

    @OneToMany(mappedBy = "restaurant",
               cascade = CascadeType.ALL,// When you change a restaurant, you'd also want to be able to change the menu
               orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    // Kinda like having an Entity be the owner of the join table
    @ManyToMany
    @JoinTable(name = "restaurantpayments",
               joinColumns = @JoinColumn(name = "restaurantid"), // the column name inside of this class
               inverseJoinColumns = @JoinColumn(name = "paymentid") //paymentid comes from the payment model class
              )
    List<Payment> payments = new ArrayList<>();
}
