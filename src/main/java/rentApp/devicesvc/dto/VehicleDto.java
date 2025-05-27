package rentApp.devicesvc.dto;

import lombok.*;
import rentApp.devicesvc.model.Device;
import rentApp.devicesvc.model.VehicleConfig;
import rentApp.devicesvc.model.VehicleModel;

import java.util.Locale;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    String registrationNumber;
    VehicleConfig vehicleConfig;
    VehicleModel vehicleModel;
    DeviceDto device;
    boolean isAvailable;
    Locale locale;
    String nodes;
}
