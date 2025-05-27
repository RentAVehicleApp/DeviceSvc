package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rentApp.devicesvc.dao.VehicleRepository;
import rentApp.devicesvc.dto.FindVehicleByParamDto;
import rentApp.devicesvc.dto.VehicleDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServisImpl implements VehicleService{
    final VehicleRepository deviceRepository;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public VehicleDto findVehicleById(long id) {
        return null;
    }

    @Override
    public List<VehicleDto> findVehicleByParams(FindVehicleByParamDto findVehicleByParamDto) {
        return List.of();
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public void removeVehicle(long id) {

    }
}
