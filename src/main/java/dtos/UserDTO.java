package dtos;

public class UserDTO {
    private Long id;
    private String name;
    private String location;
    private String profilePicture;
    private String userType;

    public UserDTO(Long id, String name, String location, String profilePicture, String userType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.profilePicture = profilePicture;
        this.userType = userType;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
}

