package rentApp.devicesvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Builder
public class DeviceModel {
    @Id
    private Long id;

    private String name;

    private String serialNumber;

}
