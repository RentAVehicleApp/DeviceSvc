package rentApp.devicesvc.dto;

import lombok.*;
import rentApp.devicesvc.model.VehicleModel;

import java.util.Locale;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListVehiclesRequest {
    String registrationNumber;
    VehicleModel vehicleModel;
    ListDevicesRequest device;
    boolean isAvailable;
    Locale locale;
    String nodes;
}
