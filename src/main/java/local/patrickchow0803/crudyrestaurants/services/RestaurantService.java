package local.patrickchow0803.crudyrestaurants.services;

import local.patrickchow0803.crudyrestaurants.models.Restaurant;

import java.util.List;

//This interface shows all the functionality that can be done by the controllers
public interface RestaurantService {

    //Find all the restaurants
    List<Restaurant> findAll();

    //Find a restaurant by id
    Restaurant findRestaurantById(long id);

    //Find a restaurant by name
    Restaurant findRestaurantByName(String name);

    //Find a list of restaurants by their state
    List<Restaurant> findByState(String state);

    //Find a list of restaurants by similar name
    List<Restaurant> findByNameLike(String thename);

}
