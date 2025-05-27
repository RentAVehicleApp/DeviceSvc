package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rentApp.devicesvc.dao.DeviceConfigRepository;
import rentApp.devicesvc.dao.DeviceModelRepository;
import rentApp.devicesvc.dao.DeviceRepository;
import rentApp.devicesvc.dto.DeviceConfigDto;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.DeviceModelDto;
import rentApp.devicesvc.dto.FindDeviceByParamDto;
import rentApp.devicesvc.exception.DuplicateDeviceException;
import rentApp.devicesvc.exception.EntityNotFoundException;
import rentApp.devicesvc.model.Device;
import rentApp.devicesvc.model.DeviceConfig;
import rentApp.devicesvc.model.DeviceModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    final DeviceRepository deviceRepository;
    final DeviceConfigRepository deviceConfigRepository;
    final DeviceModelRepository deviceModelRepository;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public DeviceDto createDevice(DeviceDto deviceDto) {

        if (deviceRepository.existsBySerialNumber(deviceDto.getSerialNumber())) {
            throw new DuplicateDeviceException("Device with this serial number already exists");
        }

        DeviceConfig deviceConfig = getDeviceConfigIfExistOrCreateNew(deviceDto.getDeviceConfig());

        DeviceModel deviceModel = getDeviceModelIfExistOrCreateNew(deviceDto.getDeviceModel());

        Device device = Device.builder()
                .deviceConfig(deviceConfig)
                .deviceModel(deviceModel)
                .nodes(deviceDto.getNodes())
                .serialNumber(deviceDto.getSerialNumber())
                .build();

        return modelMapper.map(deviceRepository.save(device), DeviceDto.class);
    }

    private DeviceConfig getDeviceConfigIfExistOrCreateNew(DeviceConfigDto deviceConfigDto) {
        DeviceConfig deviceConfig = deviceConfigRepository
                .findByNameOfConfig(deviceConfigDto.getNameOfConfig())
                .orElseGet(() ->
                        deviceConfigRepository.save(
                                modelMapper.map(deviceConfigDto, DeviceConfig.class)
                        )
                );
        return deviceConfig;
    }

    private DeviceModel getDeviceModelIfExistOrCreateNew(DeviceModelDto deviceModelDto) {
        DeviceModel deviceModel = deviceModelRepository
                .findByName(deviceModelDto.getName())
                .orElseGet(() ->
                        deviceModelRepository.save(
                                modelMapper.map(deviceModelDto, DeviceModel.class)
                        )
                );
        return deviceModel;
    }

    @Transactional(readOnly = true)
    @Override
    public DeviceDto findDeviceById(long id) {
        Device device = deviceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(device, DeviceDto.class);
    }

    @Override
    public List<DeviceDto> findDevicesByParams(FindDeviceByParamDto findDeviceByParamDto) {
//        List<Device> devices 
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
            device.setDeviceModel(getDeviceModelIfExistOrCreateNew(deviceDto.getDeviceModel()));
        }

        if (deviceDto.getNodes() != null) {
            device.setNodes(deviceDto.getNodes());
        }

        if (deviceDto.getDeviceConfig() != null) {
            device.setDeviceConfig(getDeviceConfigIfExistOrCreateNew(deviceDto.getDeviceConfig()));
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
