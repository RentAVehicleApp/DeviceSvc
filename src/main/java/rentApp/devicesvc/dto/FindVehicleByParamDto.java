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
public class FindVehicleByParamDto {
    String registrationNumber;
    VehicleConfig vehicleConfig;
    VehicleModel vehicleModel;
    FindDeviceByParamDto device;
    boolean isAvailable;
    Locale locale;
    String nodes;
}
