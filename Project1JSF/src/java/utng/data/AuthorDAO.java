package utng.data;

import org.hibernate.HibernateException;
import utng.model.Author;


public class AuthorDAO extends DAO<Author>{
     public AuthorDAO() {
        super(new Author());
    }

    
    public Author getOneById(Author author) throws HibernateException {
        return super.getOneById(author.getIdAuthor());
    }
}
