package entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("consultant")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Consultant extends User {
        private String expertise;
        private int yearsOfExperience;
}

