package rentApp.devicesvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rentApp.devicesvc.model.VehicleModel;

import java.util.Optional;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
    Optional<VehicleModel> findByName(String name);
}
