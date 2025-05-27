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
    private DeviceConfigDto deviceConfig;
    private DeviceModelDto deviceModel;
    private String nodes;
}
