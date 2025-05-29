package rentApp.devicesvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.ListDevicesRequest;
import rentApp.devicesvc.service.DeviceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/devices")
public class DeviceController {
    final DeviceService deviceService;

    @PostMapping
    public DeviceDto createDevice (@RequestBody DeviceDto deviceDto) {
        return deviceService.createDevice(deviceDto);
    }

    @GetMapping("/{id}")
    public DeviceDto findDeviceById (@PathVariable long id) {
        return deviceService.findDeviceById (id);
    }

    @GetMapping("/list")
    public List<DeviceDto> findDevicesByParams (@ModelAttribute ListDevicesRequest listDevicesRequest) {
        return deviceService.findDevicesByParams(listDevicesRequest);
    }

    @PutMapping("/{id}")
    public DeviceDto updateDevice (@PathVariable long id, @RequestBody DeviceDto deviceDto) {
        return deviceService.updateDevice (id, deviceDto);
    }

    @DeleteMapping("/{id}")
    public void removeDevice (@PathVariable long id) {
        deviceService.removeDevice (id);
    }



}
