package services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import dtos.UserDTO;
import entities.User;
import repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> searchUsers(String keyword) {
        List<User> users = userRepository.searchUsers(keyword);
        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getLocation(),
                        user.getProfilePicture(),
                        user.getUserType()))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getLocation(),
                user.getProfilePicture(),
                user.getUserType()
        );
    }
}

