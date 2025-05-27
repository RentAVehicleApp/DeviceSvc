package rentApp.devicesvc.dto;


import lombok.*;
import rentApp.devicesvc.model.DeviceConfig;
import rentApp.devicesvc.model.DeviceModel;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindDeviceByParamDto {

    private String serialNumber;
    private DeviceConfig deviceConfig;
    private DeviceModel deviceModel;
    private boolean isConnected;
    private String nodes;
}
