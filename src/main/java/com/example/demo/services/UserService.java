package com.example.demo.services;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLocation(userDTO.getLocation());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setCompanyName(userDTO.getCompanyName());
        user.setRatings(userDTO.getRatings());
        user.setOngoingWorks(userDTO.getOngoingWorks());
        user.setHotDeals(userDTO.getHotDeals());
        user.setCompletedWork(userDTO.getCompletedWork());
        user.setAvailable(userDTO.isAvailable());

        userRepository.save(user);
        return userDTO;
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    public List<UserDTO> searchUsers(String query) {
        List<User> users = userRepository.searchUsers(query);
        return users.stream().map(this::convertToDTO).toList();
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
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }


    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLocation(user.getLocation());
        dto.setProfilePicture(user.getProfilePicture());
        dto.setCompanyName(user.getCompanyName());
        dto.setRatings(user.getRatings());
        dto.setOngoingWorks(user.getOngoingWorks());
        dto.setHotDeals(user.getHotDeals());
        dto.setCompletedWork(user.getCompletedWork());
        dto.setAvailable(user.isAvailable());
        return dto;
    }

}
