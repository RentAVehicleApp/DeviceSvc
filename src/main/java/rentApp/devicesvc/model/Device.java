package rentApp.devicesvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Builder

public class Device {
    @Id
    private long id;

    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeviceConfig deviceConfig;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeviceModel deviceModel;

    private boolean isConnected;

    private String nodes;

}
