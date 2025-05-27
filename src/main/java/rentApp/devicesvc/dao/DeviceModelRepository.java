package rentApp.devicesvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rentApp.devicesvc.model.DeviceModel;

import java.util.Optional;

public interface DeviceModelRepository extends JpaRepository<DeviceModel,Long> {
    Optional<DeviceModel> findByName(String name);
}
