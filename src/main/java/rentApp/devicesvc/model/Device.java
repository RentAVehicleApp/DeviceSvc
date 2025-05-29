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

//todo: annotation Index - google it for field serialNumber
public class Device {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //todo во всех остальных энтити
    @Column(unique = true)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeviceConfig deviceConfig;


    private DeviceModel deviceModel;

    private boolean isConnected;

    @Column(columnDefinition = "TEXT") //todo check if it is right
    private String nodes;

}
