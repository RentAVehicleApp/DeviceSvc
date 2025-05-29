package rentApp.devicesvc.service;


import rentApp.devicesvc.dto.ListVehiclesRequest;
import rentApp.devicesvc.dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto findVehicleById(long id);

    List<VehicleDto> findVehicleByParams(ListVehiclesRequest listVehiclesRequest);

    VehicleDto updateVehicle(long id, VehicleDto vehicleDto);

    void removeVehicle(long id);
}
