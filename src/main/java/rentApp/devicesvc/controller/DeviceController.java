package rentApp.devicesvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.FindDeviceByParamDto;
import rentApp.devicesvc.service.DeviceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {
    final DeviceService deviceService;

    @PostMapping("/create")
    public DeviceDto createDevice (@RequestBody DeviceDto deviceDto) {
        return deviceService.createDevice(deviceDto);
    }

    @GetMapping("/findById/{id}")
    public DeviceDto findDeviceById (@PathVariable long id) {
        return deviceService.findDeviceById (id);
    }

    @GetMapping("/findByParam")
    public List<DeviceDto> findDevicesByParams (@ModelAttribute FindDeviceByParamDto findDeviceByParamDto) {
        return deviceService.findDevicesByParams(findDeviceByParamDto);
    }

    @PutMapping("/update/{id}")
    public DeviceDto updateDevice (@PathVariable long id, @RequestBody DeviceDto deviceDto) {
        return deviceService.updateDevice (id, deviceDto);
    }

    @DeleteMapping("/remove/{id}")
    public void removeDevice (@PathVariable long id) {
        deviceService.removeDevice (id);
    }



}
