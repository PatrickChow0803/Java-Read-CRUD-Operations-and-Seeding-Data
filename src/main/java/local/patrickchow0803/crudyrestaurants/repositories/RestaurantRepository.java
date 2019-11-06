package local.patrickchow0803.crudyrestaurants.repositories;

import local.patrickchow0803.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    Restaurant findByName(String name);

    ArrayList<Restaurant> findByStateIgnoringCase(String state);

    ArrayList<Restaurant> findByNameContainingIgnoringCase(String likename);
}
