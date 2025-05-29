package rentApp.devicesvc.service;

import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.ListDevicesRequest;

import java.util.List;

public interface DeviceService {
    DeviceDto createDevice(DeviceDto deviceDto);

    DeviceDto findDeviceById(long id);

    List<DeviceDto> findDevicesByParams(ListDevicesRequest listDevicesRequest);

    DeviceDto updateDevice(long id, DeviceDto deviceDto);

    void removeDevice(long id);
}
