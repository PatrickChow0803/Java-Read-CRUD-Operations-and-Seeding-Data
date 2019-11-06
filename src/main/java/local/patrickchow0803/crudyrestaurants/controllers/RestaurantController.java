package local.patrickchow0803.crudyrestaurants.controllers;

import local.patrickchow0803.crudyrestaurants.models.Restaurant;
import local.patrickchow0803.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Tells spring that this is a controller
@RestController

//All the endpoints being with restaurants
@RequestMapping("/restaurants")
public class RestaurantController {


    @Autowired
    // Lets the controller know that the service exists
    private RestaurantService restaurantService;

    // Find all the restaurants
    // http://localhost:2019/restaurants/restaurants
    // This is a GET function therefore use @GetMapping
    @GetMapping(value = "/restaurants",
                produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants(){
        List<Restaurant> myRestaurants = restaurantService.findAll();
        return new ResponseEntity<>(myRestaurants, HttpStatus.OK);
    }

    // Find a restaurant by an id
    // http://localhost:2019/restaurants/restaurant/3
    @GetMapping(value = "/restaurant/{restid}",
            produces = {"application/json"})
    public ResponseEntity<?> findRestaurantById(@PathVariable long restid){
        Restaurant myRestaurant = restaurantService.findRestaurantById();
        return new ResponseEntity<>(myRestaurant, HttpStatus.OK);
    }

    // Find a restaurant by the name
    // http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats
    @GetMapping(value = "/restaurant/name/{restname}",
            produces = {"application/json"})
    public ResponseEntity<?> findRestaurantByName(@PathVariable String restname){
        Restaurant myRestaurant = restaurantService.findRestaurantByName(restname);
        return new ResponseEntity<>(myRestaurant, HttpStatus.OK);
    }

    // Find a list of restaurants by state
    // http://localhost:2019/restaurants/restaurant/state/st
    @GetMapping(value = "/restaurant/state/{state}",
            produces = {"application/json"})
    public ResponseEntity<?> findRestaurantByState(@PathVariable String state){
        List<Restaurant> myRestaurants = restaurantService.findByState(state);
        return new ResponseEntity<>(myRestaurants, HttpStatus.OK);
    }

    // Find a restaurant based on a similar name. Ex: Anything with "eat" would return
    // http://localhost:2019/restaurants/restaurant/likename/eat
    @GetMapping(value = "/restaurant/like/{restname}",
            produces = {"application/json"})
    public ResponseEntity<?> findRestaurantByNameLike(@PathVariable String restname){
        List<Restaurant> myRestaurants = restaurantService.findByNameLike(restname);
        return new ResponseEntity<>(myRestaurants, HttpStatus.OK);
    }
}
