package utng.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.model.Song;


public class SongDAO extends DAO<Song>{
    public SongDAO() {
        super(new Song());
    }
    public Song getOneById(Song song) throws HibernateException {
        return super.getOneById(song.getIdSong()); 
    }
}
