package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rentApp.devicesvc.dao.DeviceConfigRepository;
import rentApp.devicesvc.dto.DeviceConfigDto;
import rentApp.devicesvc.exception.EntityNotFoundException;
import rentApp.devicesvc.model.DeviceConfig;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceConfigServiceImpl implements DeviceConfigService
//        , CommandLineRunner
{
    final DeviceConfigRepository deviceConfigRepository;
    final ModelMapper modelMapper;


    @Transactional
    @Override
    public DeviceConfigDto createDeviceConfig(DeviceConfigDto deviceConfigDto) {
        DeviceConfig deviceConfig = DeviceConfig.builder()
                .name(deviceConfigDto.getName())
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
        deviceConfig.setName(deviceConfigDto.getName());
        return modelMapper.map(deviceConfigRepository.save(deviceConfig), DeviceConfigDto.class);
    }

    @Transactional
    @Override
    public void removeDeviceConfig(long id) {
        DeviceConfig deviceConfig = deviceConfigRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        deviceConfigRepository.delete(deviceConfig);
    }

//    @Transactional(readOnly = true)
//    @Override
//    public DeviceConfigDto findDeviceConfigByName(String name) {
//        deviceConfigRepository.findByNameOfConfig(name).orElseThrow(EntityNotFoundException::new);
//        return modelMapper.map(deviceConfigRepository.findByNameOfConfig(name), DeviceConfigDto.class);
//    }

    @Override
    public List<DeviceConfigDto> getListDevicesConfig() {
        return List.of();
    }

//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        if (deviceConfigRepository.count() == 0) {
//            DeviceConfig deviceConfig = DeviceConfig.builder().name("Config1").build();
//            deviceConfigRepository.save(deviceConfig);
//            System.out.println("log1: " + deviceConfig.getId());
//        }
//    }

}
