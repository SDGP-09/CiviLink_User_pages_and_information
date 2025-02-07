package controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import services.UserService;
import dtos.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

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
}
