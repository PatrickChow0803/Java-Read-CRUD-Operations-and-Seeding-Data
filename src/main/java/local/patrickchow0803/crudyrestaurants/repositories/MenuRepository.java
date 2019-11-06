package local.patrickchow0803.crudyrestaurants.repositories;

import local.patrickchow0803.crudyrestaurants.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
}
