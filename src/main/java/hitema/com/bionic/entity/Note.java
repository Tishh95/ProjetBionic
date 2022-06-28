package hitema.com.bionic.entity;

import javax.persistence.*;

@Entity
    @Table(name = "note")
public class Note {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="id")
    private long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Column(name="club_id")
    private long club_id;
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

    public void setUser_id(long user_id) {
        this.user.setId(user_id);
    }

    public long getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
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
