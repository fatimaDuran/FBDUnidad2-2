package utng.driver;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.AuthorDAO;
import utng.model.Author;


@ManagedBean
@SessionScoped
public class AuthorBean implements Serializable{
    private List<Author>authors;
    private Author author;
    
    public AuthorBean(){}

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

 
    
    public String tolist(){
        AuthorDAO dao = new AuthorDAO();
        try {
            authors=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Authors";
    }
    
    public String delete(){
         AuthorDAO dao = new AuthorDAO();
        try {
            dao.delete(author);
            authors=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        author= new Author();
        return "Start";
    }
    
    public String save(){
       AuthorDAO dao = new AuthorDAO();
        try {
            if(author.getIdAuthor()!= 0){
                dao.update(author);
            }else {
                dao.insert(author);
            }
            authors=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Author author){
        this.author=author;
        return "Edit";
    }
}
