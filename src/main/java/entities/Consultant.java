package entities;
import jakarta.persistence.*;
import jakarta.persistence.DiscriminatorValue;
import lombok.*;

@Entity
@DiscriminatorValue("consultant")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Consultant extends User {
        private String specialization;
        private String qualifications;
        private String services;
        private double minProjectValue;
        private double professionalFee;
        private double platformFee;
}

