package entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("contractor")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contractor extends User {
    private String companyName;
    private String specialization;
}

