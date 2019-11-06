package local.patrickchow0803.crudyrestaurants.repositories;

import local.patrickchow0803.crudyrestaurants.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
