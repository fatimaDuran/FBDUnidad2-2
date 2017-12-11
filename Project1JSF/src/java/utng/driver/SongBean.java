package utng.driver;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.data.AuthorDAO;
import utng.data.SongDAO;
import utng.model.Author;
import utng.model.Song;



@ManagedBean(name = "songBean")
@SessionScoped
public class SongBean implements Serializable{
    private List<Song> songs;
    private Song song;
    private List<Author> authors; 

    public SongBean() {
       song = new Song();
       song.setAuthor(new Author());
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

   
    public String tolist() {
        SongDAO dao = new SongDAO();
        try {
            songs = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Songs";
    }

    public String delete() {
        SongDAO dao = new SongDAO();
        try {
            dao.delete(song);
            songs = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }

    public String start() {
        song= new Song();
        song.setAuthor(new Author());
        try {
            authors = new AuthorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }

    public String save() {
       SongDAO dao = new SongDAO();
        try {
            if (song.getIdSong() != 0) {
                dao.update(song);
            } else {
                dao.insert(song);
            }
            songs= dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }

    public String cancel() {
        return "Cancel";
    }

    public String edit(Song song) {
        this.song= song;
        try {
            authors = new AuthorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
}
