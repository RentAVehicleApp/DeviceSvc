package rentApp.devicesvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rentApp.devicesvc.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    boolean existsByRegistrationNumber(String registrationNumber);
}
