package dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String location;
    private String profilePicture;
    private String userType;

    private String companyName;
    private double ratings;
    private String ongoingWorks;
    private String hotDeals;
    private String completedWork;

    private String specialization;
    private String qualifications;
    private String services;
    private double minProjectValue;
    private double professionalFee;
    private double platformFee;
}

