package rentApp.devicesvc.model;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.io.Serializable;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Builder
public class Vehicle implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String registrationNumber;

    @OneToOne(fetch = FetchType.EAGER)
    private Device device;

    @Column(unique = true)
    private VehicleModel vehicleModel;

    private boolean isAvailable;

    @Column (columnDefinition = "geometry(Point,4326)")
    private Point location;

    @Column (columnDefinition = "TEXT")
    private String nodes;

}
