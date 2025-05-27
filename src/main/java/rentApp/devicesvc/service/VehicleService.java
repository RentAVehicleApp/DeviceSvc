package rentApp.devicesvc.service;


import rentApp.devicesvc.dto.FindVehicleByParamDto;
import rentApp.devicesvc.dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto findVehicleById(long id);

    List<VehicleDto> findVehicleByParams(FindVehicleByParamDto findVehicleByParamDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void removeVehicle(long id);
}
