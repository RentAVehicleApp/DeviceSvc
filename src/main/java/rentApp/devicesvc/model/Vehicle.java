package rentApp.devicesvc.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Builder
public class Vehicle {
    @Id
    long id;

    String registrationNumber;

    @OneToOne(fetch = FetchType.EAGER)
    Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    VehicleConfig vehicleConfig;

    @ManyToOne(fetch = FetchType.LAZY)
    VehicleModel vehicleModel;

    boolean isAvailable;

    Locale locale;

    String nodes;

}
