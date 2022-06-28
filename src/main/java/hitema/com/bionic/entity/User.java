package hitema.com.bionic.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "user")
public class User {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="user_id")
    private long id;

    @ManyToMany
    @JoinTable( name = "user_club",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "club_id" ) )
    private List<Club> clubs = new ArrayList<>();

    @Column(name="username")
    private String name;
    @Column(name="Password")
    private String password;
    @Column(name="date_create")
    private LocalDateTime creationDate;

    @OneToMany( targetEntity=Note.class, mappedBy = "user")
    private List<Note> notes = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public List<Note> getNotes(){
        return notes;
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
