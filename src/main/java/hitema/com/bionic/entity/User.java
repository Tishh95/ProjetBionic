package hitema.com.bionic.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "User")
public class User {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="ID")
    private int id;

    @ManyToMany
    @JoinTable( name = "User_Club",
            joinColumns = @JoinColumn( name = "User_ID" ),
            inverseJoinColumns = @JoinColumn( name = "Club_ID" ) )
    private List<Club> clubs = new ArrayList<>();

    @Column(name="UserName")
    private String name;
    @Column(name="Password")
    private String password;
    @Column(name="Date_Create")
    private LocalDateTime creationDate;

    @OneToMany( targetEntity=Note.class, mappedBy="Notes" )
    private List<Note> notes = new ArrayList<>();

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
