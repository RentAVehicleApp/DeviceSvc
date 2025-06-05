package rentApp.devicesvc.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


public enum DeviceModel {
    MODEL1, MODEL2, MODEL3;

    @JsonCreator
    public static DeviceModel from(String value) {
        return value == null ? null : DeviceModel.valueOf(value.toUpperCase());
    }
}
