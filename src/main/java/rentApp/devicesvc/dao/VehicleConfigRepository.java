package rentApp.devicesvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rentApp.devicesvc.model.VehicleConfig;

import java.util.Optional;

public interface VehicleConfigRepository extends JpaRepository<VehicleConfig, Long> {
    Optional<VehicleConfig> findByNameOfConfig(String nameOfConfig);
}
