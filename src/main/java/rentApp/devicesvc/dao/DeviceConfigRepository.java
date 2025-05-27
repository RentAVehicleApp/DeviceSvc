package rentApp.devicesvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rentApp.devicesvc.model.DeviceConfig;

import java.util.Optional;

public interface DeviceConfigRepository extends JpaRepository<DeviceConfig,Long> {
    Optional<DeviceConfig> findByNameOfConfig(String nameOfConfig);
}
