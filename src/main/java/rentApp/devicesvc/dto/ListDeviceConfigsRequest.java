package rentApp.devicesvc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListDeviceConfigsRequest {
    String nameOfConfig;
}
