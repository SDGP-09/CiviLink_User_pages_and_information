package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.entities.Contractor;
import com.example.demo.entities.Consultant;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> searchUsers(String keyword) {
        List<User> users = userRepository.searchUsers(keyword);
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    public UserDTO addContractor(UserDTO userDTO) {
        Contractor contractor = new Contractor();
        contractor.setName(userDTO.getName());
        contractor.setLocation(userDTO.getLocation());
        contractor.setProfilePicture(userDTO.getProfilePicture());
        contractor.setCompanyName(userDTO.getCompanyName());
        contractor.setRatings(userDTO.getRatings());
        contractor.setOngoingWorks(userDTO.getOngoingWorks());
        contractor.setHotDeals(userDTO.getHotDeals());
        contractor.setCompletedWork(userDTO.getCompletedWork());

        userRepository.save(contractor);
        return convertToDTO(contractor);
    }

    public UserDTO addConsultant(UserDTO userDTO) {
        Consultant consultant = new Consultant();
        consultant.setName(userDTO.getName());
        consultant.setLocation(userDTO.getLocation());
        consultant.setProfilePicture(userDTO.getProfilePicture());
        consultant.setSpecialization(userDTO.getSpecialization());
        consultant.setQualifications(userDTO.getQualifications());
        consultant.setServices(userDTO.getServices());
        consultant.setMinProjectValue(userDTO.getMinProjectValue());
        consultant.setProfessionalFee(userDTO.getProfessionalFee());
        consultant.setPlatformFee(userDTO.getPlatformFee());

        userRepository.save(consultant);
        return convertToDTO(consultant);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDTO.getName());
        user.setLocation(userDTO.getLocation());
        user.setProfilePicture(userDTO.getProfilePicture());

        userRepository.save(user);
        return convertToDTO(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getLocation(),
                user.getProfilePicture(),
                user.getUserType(),
                (user instanceof Contractor) ? ((Contractor) user).getCompanyName() : null,
                (user instanceof Contractor) ? ((Contractor) user).getRatings() : 0,
                null, null, null, // Contractor extra fields
                null, null, null, 0, 0, 0 // Consultant extra fields
        );
    }
}

