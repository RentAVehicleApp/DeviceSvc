package rentApp.devicesvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rentApp.devicesvc.model.Device;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
}
