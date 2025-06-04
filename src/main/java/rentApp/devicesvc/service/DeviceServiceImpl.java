package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rentApp.devicesvc.dao.DeviceConfigRepository;
import rentApp.devicesvc.dao.DeviceRepository;
import rentApp.devicesvc.dto.DeviceConfigDto;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.ListDevicesRequest;
import rentApp.devicesvc.exception.DuplicateDeviceException;
import rentApp.devicesvc.exception.EntityNotFoundException;
import rentApp.devicesvc.model.Device;
import rentApp.devicesvc.model.DeviceConfig;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    final DeviceRepository deviceRepository;
    final DeviceConfigService deviceConfigService;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public DeviceDto createDevice(DeviceDto deviceDto) {

        if (deviceRepository.existsBySerialNumber(deviceDto.getSerialNumber())) {
            throw new DuplicateDeviceException("Device with this serial number already exists");
        }


        Device device = Device.builder()
                .deviceConfig(modelMapper.map(
                        deviceConfigService.findDeviceConfigById(deviceDto.getDeviceConfigId())
                                , DeviceConfig.class))
                .deviceModel(deviceDto.getDeviceModel())
                .nodes(deviceDto.getNodes())
                .serialNumber(deviceDto.getSerialNumber())
                .build();

        return modelMapper.map(deviceRepository.save(device), DeviceDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public DeviceDto findDeviceById(long id) {
        Device device = deviceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(device, DeviceDto.class);
    }

    @Override
    public List<DeviceDto> findDevicesByParams(ListDevicesRequest listDevicesRequest) {
//        List<Device> devices
        //TODO Spring Data JPA + JpaSpecificationExecutor
        return List.of();
    }

    @Transactional
    @Override
    public DeviceDto updateDevice(long id, DeviceDto deviceDto) {
        Device device = deviceRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (deviceDto.getSerialNumber() != null) {
            device.setSerialNumber(deviceDto.getSerialNumber());
        }
        
        if (deviceDto.getDeviceModel() != null) {
            device.setDeviceModel(deviceDto.getDeviceModel());
        }

        if (deviceDto.getNodes() != null) {
            device.setNodes(deviceDto.getNodes());
        }

        if (deviceDto.getDeviceConfigId() != 0) {
            device.setDeviceConfig(modelMapper.map
                    (deviceConfigService.findDeviceConfigById(deviceDto.getDeviceConfigId() //todo is t ok modalmapper here?
                    ), DeviceConfig.class)
            );

        }

        deviceRepository.save(device);
        return modelMapper.map(device, DeviceDto.class);
    }

    @Transactional
    @Override
    public void removeDevice(long id) {
        Device device = deviceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        deviceRepository.delete(device);
    }
}
