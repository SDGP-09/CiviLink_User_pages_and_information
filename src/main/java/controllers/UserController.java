package controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import services.UserService;
import dtos.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public List<UserDTO> searchUsers(@RequestParam String query) {
        return userService.searchUsers(query);
    }

    @GetMapping("/{id}")
    public UserDTO getUserProfile(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/contractors")
    public UserDTO addContractor(@RequestBody UserDTO userDTO) {
        return userService.addContractor(userDTO);
    }

    @PostMapping("/consultants")
    public UserDTO addConsultant(@RequestBody UserDTO userDTO) {
        return userService.addConsultant(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

