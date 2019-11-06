package local.patrickchow0803.crudyrestaurants.services;

import local.patrickchow0803.crudyrestaurants.models.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value ="restaurantService") //Is the same name as the interface in the RestaurantController
// This class will be the implementation of the RestaurantService interface
public class RestaurantServiceImpl implements RestaurantService {
    @Override
    public List<Restaurant> findAll() {
        return null;
    }

    @Override
    public Restaurant findRestaurantById(long id) {
        return null;
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return null;
    }

    @Override
    public List<Restaurant> findByState(String state) {
        return null;
    }

    @Override
    public List<Restaurant> findByNameLike(String thename) {
        return null;
    }
}
