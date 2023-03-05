package flowix.main.flowixlab.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Table(name = "flowix")
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "telegram_id")
    private String telegramId;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "role")
    private String role;

    @Column(name = "auth_date")
    private String authDate;

    @Column(name = "due_date")
    private String dueDate;

    public Admin(String username, String telegram, boolean active, String role, String authDate, String dueDate) {
        this.username = username;
        this.telegramId = telegram;
        this.active = active;
        this.role = role;
        this.authDate = authDate;
        this.dueDate = dueDate;
    }

    public Admin() {
    }

}

