package rentApp.devicesvc.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import rentApp.devicesvc.model.DeviceConfig;
import rentApp.devicesvc.model.DeviceModel;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {
//    @UniqueConstraint() //todo Unique
    private String serialNumber;
    private long deviceConfigId;
    private DeviceModel deviceModel;
    private String nodes;
}

