package local.patrickchow0803.crudyrestaurants.repositories;

import local.patrickchow0803.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
