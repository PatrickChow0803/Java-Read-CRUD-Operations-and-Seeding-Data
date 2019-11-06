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

    public Restaurant(){
        // Spring Data JPA Requires this default constructor
    }

    public Restaurant(String name, String address, String city, String state, String telephone, int seatcapacity) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.seatcapacity = seatcapacity;
    }

    public long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getSeatcapacity() {
        return seatcapacity;
    }

    public void setSeatcapacity(int seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
