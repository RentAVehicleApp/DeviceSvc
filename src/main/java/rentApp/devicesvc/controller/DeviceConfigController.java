package rentApp.devicesvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rentApp.devicesvc.dto.DeviceConfigDto;
import rentApp.devicesvc.dto.DeviceDto;
import rentApp.devicesvc.dto.ListDeviceConfigsRequest;
import rentApp.devicesvc.dto.ListDevicesRequest;
import rentApp.devicesvc.service.DeviceConfigService;
import rentApp.devicesvc.service.DeviceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/deviceconfig")
public class DeviceConfigController {
    final DeviceConfigService deviceConfigService;

    @PostMapping
    public DeviceConfigDto createDeviceConfig (@RequestBody DeviceConfigDto deviceConfigDto) {
        return deviceConfigService.createDeviceConfig(deviceConfigDto);
    }

    @GetMapping("/id/{id}")
    public DeviceConfigDto findDeviceConfigById (@PathVariable long id) {
        return deviceConfigService.findDeviceConfigById (id);
    }

    @GetMapping("/list")
    public List<DeviceConfigDto> getListDevicesConfig () {
        return deviceConfigService.getListDevicesConfig();
    }

//    @GetMapping("/name/{name}")
//    public DeviceConfigDto findDeviceConfigByName (@PathVariable String name) {
//        return deviceConfigService.findDeviceConfigByName(name);
//    }

    @PutMapping("/id/{id}")
    public DeviceConfigDto updateDeviceConfig (@PathVariable long id, @RequestBody DeviceConfigDto deviceConfigDto) {
        return deviceConfigService.updateDeviceConfig (id, deviceConfigDto);
    }

    @DeleteMapping("/id/{id}")
    public void removeDeviceConfig (@PathVariable long id) {
        deviceConfigService.removeDeviceConfig (id);
    }

    // отдельно модуль сервиса  И будет отдельно девайс модуль.
    // И девайс модуль будет содержать только дто, которые испольщубтся везде



}
