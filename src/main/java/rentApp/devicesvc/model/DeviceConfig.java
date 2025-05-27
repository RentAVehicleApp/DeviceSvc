package rentApp.devicesvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
@Getter
@Setter
@ToString
@Builder

public class DeviceConfig {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String nameOfConfig;
}
