package rentApp.devicesvc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceModelDto {
    private String name;
    private String serialNumber;
}
