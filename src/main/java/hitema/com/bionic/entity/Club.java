package hitema.com.bionic.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "club")
public class Club {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="club_id")
    private long id;
    @Column(name="club_name")
    private String name;
    @Column(name="admin")
    private int creatorId;
    @Column(name="date_create")
    private LocalDateTime creationDate;

    @ManyToMany
    @JoinTable( name = "user_club",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "club_id" ) )
    private List<User> users = new ArrayList<>();

    @OneToMany(targetEntity=Note.class)
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
