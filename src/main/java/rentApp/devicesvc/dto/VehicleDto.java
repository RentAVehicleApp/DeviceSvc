package rentApp.devicesvc.dto;

import lombok.*;
import rentApp.devicesvc.model.VehicleModel;

import java.util.Locale;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    //TODO check not null, format reg number, not exist - для этого создать свой кастомный валидатор Unic и переношу туда логику
    String registrationNumber;
    VehicleModel vehicleModel;
    DeviceDto device;
    boolean isAvailable;
    Locale locale;
    String nodes;
}
