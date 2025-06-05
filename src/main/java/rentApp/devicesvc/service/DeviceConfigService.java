package rentApp.devicesvc.service;

import rentApp.devicesvc.dto.DeviceConfigDto;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.ListDeviceConfigsRequest;

import java.util.List;

public interface DeviceConfigService {
    DeviceConfigDto createDeviceConfig(DeviceConfigDto deviceConfigDto);

    DeviceConfigDto findDeviceConfigById(long id);

    DeviceConfigDto updateDeviceConfig(long id, DeviceConfigDto deviceConfigDto);

    void removeDeviceConfig(long id);

    List<DeviceConfigDto> getListDevicesConfig();
}
