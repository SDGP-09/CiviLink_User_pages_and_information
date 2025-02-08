package entities;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String profilePicture;

    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType;

    public User() {
    }

    public User(Long id, String name, String location, String profilePicture, String userType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.profilePicture = profilePicture;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUserType() {
        return userType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
