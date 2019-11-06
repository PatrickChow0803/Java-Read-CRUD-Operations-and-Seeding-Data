package local.patrickchow0803.crudyrestaurants.models;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu {

    @Id // Makes this a primary key
    @GeneratedValue(strategy = GenerationType.AUTO)// Generates the values automatically
    private long menuid;

    //Makes sure that all dishes are unique
    @Column(nullable = true)
    private String dish;
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurantid",
                nullable = false) //Use the restaurantid from the Restaurant Model Class
    private Restaurant restaurant;

    public Menu() {
        // Spring Data JPA Requires this default constructor
    }

    public Menu(String dish, double price, Restaurant restaurant) {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public long getMenuid() {
        return menuid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
