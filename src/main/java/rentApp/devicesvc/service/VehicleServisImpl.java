package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rentApp.devicesvc.dao.VehicleRepository;
import rentApp.devicesvc.dto.ListVehiclesRequest;
import rentApp.devicesvc.dto.VehicleDto;
import rentApp.devicesvc.exception.DuplicateVehicleException;
import rentApp.devicesvc.exception.EntityNotFoundException;
import rentApp.devicesvc.model.Vehicle;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServisImpl implements VehicleService{
    final VehicleRepository vehicleRepository;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        //todo Validation - hibernate validation framework
        if (vehicleRepository.existsByRegistrationNumber(vehicleDto.getRegistrationNumber())) {
            throw new DuplicateVehicleException("Vehicle with this serial number already exists");
        }

        Vehicle vehicle = Vehicle.builder()
                .vehicleModel(vehicleDto.getVehicleModel())
                .nodes(vehicleDto.getNodes())
                .registrationNumber(vehicleDto.getRegistrationNumber())
//                .device(vehicleDto.getDevice())       //todo setDevice
                .build();

        return modelMapper.map(vehicleRepository.save(vehicle), VehicleDto.class);
    }

    @Override
    public VehicleDto findVehicleById(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> findVehicleByParams(ListVehiclesRequest listVehiclesRequest) {
        return List.of();
    }

    @Override
    public VehicleDto updateVehicle(long id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (vehicleDto.getRegistrationNumber() != null) {
            vehicle.setRegistrationNumber(vehicleDto.getRegistrationNumber());
        }

        if (vehicleDto.getVehicleModel() != null) {
            vehicle.setVehicleModel(vehicleDto.getVehicleModel());
        }

        if (vehicleDto.getNodes() != null) {
            vehicle.setNodes(vehicleDto.getNodes());
        }

        if (vehicleDto.getDevice() != null) {
            //todo setDevice
//            vehicle.setVehicleConfig(getVehicleConfigIfExistOrCreateNew(vehicleDto.getVehicleConfig()));
        }

        vehicleRepository.save(vehicle);
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public void removeVehicle(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        vehicleRepository.delete(vehicle);
    }
}
