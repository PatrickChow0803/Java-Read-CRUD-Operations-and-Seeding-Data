package local.patrickchow0803.crudyrestaurants.models;

import javax.persistence.*;

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

}
