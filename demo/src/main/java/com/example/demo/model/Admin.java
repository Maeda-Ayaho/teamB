import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID (bigserial)

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "エラーメッセージ")
    @Column(name = "username", nullable = false)
    private String username; // ユーザー名

    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "エラーメッセージ")
    @Column(name = "password", nullable = false)
    private String password; // パスワード

    public Item() {
    }

    public Item(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}