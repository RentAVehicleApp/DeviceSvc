package rentApp.devicesvc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModelDto {
    private String name;
    private String serialNumber;
}
