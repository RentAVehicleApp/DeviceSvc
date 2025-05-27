package rentApp.devicesvc.service;

import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.FindDeviceByParamDto;

import java.util.List;

public interface DeviceService {
    DeviceDto createDevice(DeviceDto deviceDto);

    DeviceDto findDeviceById(long id);

    List<DeviceDto> findDevicesByParams(FindDeviceByParamDto findDeviceByParamDto);

    DeviceDto updateDevice(long id, DeviceDto deviceDto);

    void removeDevice(long id);
}
