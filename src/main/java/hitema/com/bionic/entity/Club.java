package hitema.com.bionic.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "Club")
public class Club {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="ID")
    private long id;
    @Column(name="Club_Name")
    private String name;
    @Column(name="Admin")
    private int creatorId;
    @Column(name="Date_Create")
    private LocalDateTime creationDate;

    @ManyToMany
    @JoinTable( name = "User_Club",
            joinColumns = @JoinColumn( name = "UserID" ),
            inverseJoinColumns = @JoinColumn( name = "Club_ID" ) )
    private List<User> users = new ArrayList<>();

    @OneToMany( targetEntity=Note.class, mappedBy="Notes" )
    private List<Note> notes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<User> getUsers(){
        return users;
    }

    public List<Note> getNotes(){
        return notes;
    }

}
