package local.patrickchow0803.crudyrestaurants.services;

import local.patrickchow0803.crudyrestaurants.models.Restaurant;
import local.patrickchow0803.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value ="restaurantService") //Is the same name as the interface in the RestaurantController
// This class will be the implementation of the RestaurantService interface
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Restaurant findRestaurantById(long id) {
        return restrepos.findById(id).orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        Restaurant restaurant = restrepos.findByName(name);

        // If the restaurant isn't found, throw an EntityNotFoundException
        if(restaurant == null){
            throw new EntityNotFoundException(name);
        }

        return restaurant;
    }

    @Override
    public List<Restaurant> findByState(String state) {
        return restrepos.findByStateIgnoringCase(state);
    }

    @Override
    public List<Restaurant> findByNameLike(String thename) {
        return restrepos.findByNameContainingIgnoringCase(thename);
    }
}
