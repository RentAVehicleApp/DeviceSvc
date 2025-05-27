package rentApp.devicesvc.model;

import jakarta.persistence.*;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeviceConfig deviceConfig;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeviceModel deviceModel;

    private boolean isConnected;

    private String nodes;

}
