package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rentApp.devicesvc.dao.DeviceConfigRepository;
import rentApp.devicesvc.dto.DeviceConfigDto;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.exception.EntityNotFoundException;
import rentApp.devicesvc.model.DeviceConfig;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceConfigServiceImpl implements DeviceConfigService {
    final DeviceConfigRepository deviceConfigRepository;
    final ModelMapper modelMapper;


    @Transactional
    @Override
    public DeviceConfigDto createDeviceConfig(DeviceConfigDto deviceConfigDto) {
        DeviceConfig deviceConfig = DeviceConfig.builder()
                .nameOfConfig(deviceConfigDto.getNameOfConfig())
                .build();

        return modelMapper.map(deviceConfigRepository.save(deviceConfig),  DeviceConfigDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public DeviceConfigDto findDeviceConfigById(long id) {
        DeviceConfig deviceConfig = deviceConfigRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(deviceConfig, DeviceConfigDto.class);
    }

    @Transactional
    @Override
    public DeviceConfigDto updateDeviceConfig(long id, DeviceConfigDto deviceConfigDto) {
        DeviceConfig deviceConfig = deviceConfigRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        deviceConfig.setNameOfConfig(deviceConfigDto.getNameOfConfig());
        return modelMapper.map(deviceConfigRepository.save(deviceConfig), DeviceConfigDto.class);
    }

    @Transactional
    @Override
    public void removeDeviceConfig(long id) {
        DeviceConfig deviceConfig = deviceConfigRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        deviceConfigRepository.delete(deviceConfig);
    }

    @Transactional(readOnly = true)
    @Override
    public DeviceConfigDto findDeviceConfigByName(String name) {
        deviceConfigRepository.findByNameOfConfig(name).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(deviceConfigRepository.findByNameOfConfig(name), DeviceConfigDto.class);
    }

    @Override
    public List<DeviceConfigDto> getListDevicesConfig() {
        return List.of();
    }
}
