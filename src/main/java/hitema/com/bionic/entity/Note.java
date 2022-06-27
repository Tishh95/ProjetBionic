package hitema.com.bionic.entity;

import javax.persistence.*;

@Entity
    @Table(name = "Note")
public class Note {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="ID")
    private int id;
    @Column(name="User_ID")
    private int user_id;
    @Column(name="Club_ID")
    private int club_id;
    @Column(name="Texte")
    private String note;
    @Column(name="Note_Name")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClub_id() {
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
