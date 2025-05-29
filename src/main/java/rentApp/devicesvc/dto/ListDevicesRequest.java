package rentApp.devicesvc.dto;


import lombok.*;
import rentApp.devicesvc.model.DeviceModel;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListDevicesRequest {

    private String serialNumber;
    private DeviceConfigDto deviceConfig;
    private DeviceModel deviceModel;
    private boolean isConnected;
    private String nodes;
}
