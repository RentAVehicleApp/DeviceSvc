package rentApp.devicesvc.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import rentApp.devicesvc.model.DeviceConfig;
import rentApp.devicesvc.model.DeviceModel;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {
    private String serialNumber;
    private DeviceConfig deviceConfig;
    private DeviceModel deviceModel;
    private String nodes;
}
