package hitema.com.bionic.entity;

import javax.persistence.*;

@Entity
    @Table(name = "note")
public class Note {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="note_id")
    private long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;
    @Column(name="content")
    private String note;
    @Column(name="note_name")
    private String title;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUser_id() {
        return user.getId();
    }

    public void setUser(User user) {
        this.user = user;
    }
    public long getClub_id() {
        return club.getId();
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
