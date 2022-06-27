package hitema.com.bionic.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
    @Table(name = "User")
public class User {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="ID")
    private int id;
    @Column(name="UserName")
    private String name;
    @Column(name="Password")
    private String password;
    @Column(name="Date_Create")
    private LocalDateTime creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
