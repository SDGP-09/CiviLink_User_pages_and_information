package entities;
import jakarta.persistence.*;
import jakarta.persistence.DiscriminatorValue;
import lombok.*;

@Entity
@DiscriminatorValue("contractor")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contractor extends User {
    private String companyName;
    private double ratings;
    private String ongoingWorks;
    private String hotDeals;
    private String completedWork;
}

