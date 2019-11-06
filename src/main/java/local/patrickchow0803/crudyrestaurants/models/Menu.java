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

}
