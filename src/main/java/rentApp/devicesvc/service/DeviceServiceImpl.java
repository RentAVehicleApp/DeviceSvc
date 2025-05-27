package rentApp.devicesvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rentApp.devicesvc.dao.DeviceRepository;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.FindDeviceByParamDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService{
    final DeviceRepository deviceRepository;

    @Override
    public DeviceDto createDevice(DeviceDto deviceDto) {
        return null;
    }

    @Override
    public DeviceDto findDeviceById(long id) {
        return null;
    }

    @Override
    public List<DeviceDto> findDevicesByParams(FindDeviceByParamDto findDeviceByParamDto) {
        return List.of();
    }

    @Override
    public DeviceDto updateDevice(DeviceDto deviceDto) {
        return null;
    }

    @Override
    public void removeDevice(long id) {

    }
}
