package hitema.com.bionic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private String username;
    @Column(name="Password")
    private String password;
    @Column(name="date_create")
    private LocalDateTime creationDate;

    @OneToMany( targetEntity=Note.class, mappedBy = "user")
    private List<Note> notes = new ArrayList<>();

    public void addClub(Club club) {
        this.clubs.add(club);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
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
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
