package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rentApp.devicesvc.dao.VehicleConfigRepository;
import rentApp.devicesvc.dao.VehicleModelRepository;
import rentApp.devicesvc.dao.VehicleRepository;
import rentApp.devicesvc.dto.FindVehicleByParamDto;
import rentApp.devicesvc.dto.VehicleConfigDto;
import rentApp.devicesvc.dto.VehicleDto;
import rentApp.devicesvc.dto.VehicleModelDto;
import rentApp.devicesvc.exception.DuplicateVehicleException;
import rentApp.devicesvc.exception.EntityNotFoundException;
import rentApp.devicesvc.model.Vehicle;
import rentApp.devicesvc.model.VehicleConfig;
import rentApp.devicesvc.model.VehicleModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServisImpl implements VehicleService{
    final VehicleRepository vehicleRepository;
    final ModelMapper modelMapper;
    final VehicleConfigRepository vehicleConfigRepository;
    final VehicleModelRepository vehicleModelRepository;

    @Transactional
    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        if (vehicleRepository.existsByRegistrationNumber(vehicleDto.getRegistrationNumber())) {
            throw new DuplicateVehicleException("Vehicle with this serial number already exists");
        }

        VehicleConfig vehicleConfig = getVehicleConfigIfExistOrCreateNew(vehicleDto.getVehicleConfig());

        VehicleModel vehicleModel = getVehicleModelIfExistOrCreateNew(vehicleDto.getVehicleModel());

        Vehicle vehicle = Vehicle.builder()
                .vehicleConfig(vehicleConfig)
                .vehicleModel(vehicleModel)
                .nodes(vehicleDto.getNodes())
                .registrationNumber(vehicleDto.getRegistrationNumber())
                .build();

        return modelMapper.map(vehicleRepository.save(vehicle), VehicleDto.class);
    }

    private VehicleModel getVehicleModelIfExistOrCreateNew(VehicleModelDto vehicleModelDto) {
        return vehicleModelRepository
                .findByName(vehicleModelDto.getName())
                .orElseGet(() ->
                        vehicleModelRepository.save(
                                modelMapper.map(vehicleModelDto, VehicleModel.class)
                        )
                );
    }

    private VehicleConfig getVehicleConfigIfExistOrCreateNew(VehicleConfigDto vehicleConfigDto) {
        return vehicleConfigRepository
                .findByNameOfConfig(vehicleConfigDto.getNameOfConfig())
                .orElseGet(() ->
                        vehicleConfigRepository.save(
                                modelMapper.map(vehicleConfigDto, VehicleConfig.class)
                        )
                );
    }

    @Override
    public VehicleDto findVehicleById(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> findVehicleByParams(FindVehicleByParamDto findVehicleByParamDto) {
        return List.of();
    }

    @Override
    public VehicleDto updateVehicle(long id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (vehicleDto.getRegistrationNumber() != null) {
            vehicle.setRegistrationNumber(vehicleDto.getRegistrationNumber());
        }

        if (vehicleDto.getVehicleModel() != null) {
            vehicle.setVehicleModel(getVehicleModelIfExistOrCreateNew(vehicleDto.getVehicleModel()));
        }

        if (vehicleDto.getNodes() != null) {
            vehicle.setNodes(vehicleDto.getNodes());
        }

        if (vehicleDto.getVehicleConfig() != null) {
            vehicle.setVehicleConfig(getVehicleConfigIfExistOrCreateNew(vehicleDto.getVehicleConfig()));
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
