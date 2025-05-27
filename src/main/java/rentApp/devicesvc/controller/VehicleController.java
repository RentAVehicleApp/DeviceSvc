package rentApp.devicesvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rentApp.devicesvc.dto.FindDeviceByParamDto;
import rentApp.devicesvc.dto.FindVehicleByParamDto;
import rentApp.devicesvc.dto.VehicleDto;
import rentApp.devicesvc.service.VehicleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {
    final VehicleService vehicleService;

    @PostMapping("/create")
    public VehicleDto createVehicle (@RequestBody VehicleDto vehicleDto) {
        return vehicleService.createVehicle (vehicleDto);
    }

    @GetMapping("/findById/{id}")
    public VehicleDto findVehicleById (@PathVariable long id) {
        return vehicleService.findVehicleById (id);
    }

    @GetMapping("/findByParam")
    public List<VehicleDto> findVehicleByParams (@ModelAttribute FindVehicleByParamDto findVehicleByParamDto) {
        return vehicleService.findVehicleByParams (findVehicleByParamDto);
    }

    @PutMapping("/update/{id}")
    public VehicleDto updateVehicle (@PathVariable long id, @RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicle (id, vehicleDto);
    }

    @DeleteMapping("/remove/{id}")
    public void removeVehicle (@PathVariable long id) {
        vehicleService.removeVehicle (id);
    }

}
