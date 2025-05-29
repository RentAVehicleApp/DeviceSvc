package rentApp.devicesvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rentApp.devicesvc.dto.ListVehiclesRequest;
import rentApp.devicesvc.dto.VehicleDto;
import rentApp.devicesvc.service.VehicleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/vehicles")
public class VehicleController {
    final VehicleService vehicleService;

    @PostMapping
    public VehicleDto createVehicle (@RequestBody VehicleDto vehicleDto) {
        return vehicleService.createVehicle (vehicleDto);
    }

    @GetMapping("/{id}")
    public VehicleDto findVehicleById (@PathVariable long id) {
        return vehicleService.findVehicleById (id);
    }

    @GetMapping("/list")
    public List<VehicleDto> findVehicleByParams (@ModelAttribute ListVehiclesRequest listVehiclesRequest) {
        return vehicleService.findVehicleByParams (listVehiclesRequest);
    }

    @PutMapping("/{id}")
    public VehicleDto updateVehicle (@PathVariable long id, @RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicle (id, vehicleDto);
    }

    @DeleteMapping("/{id}")
    public void removeVehicle (@PathVariable long id) {
        vehicleService.removeVehicle (id);
    }

}
