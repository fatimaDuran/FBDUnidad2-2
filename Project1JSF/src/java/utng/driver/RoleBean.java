package utng.driver;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.RoleDAO;
import utng.model.Role;

@ManagedBean
@SessionScoped
public class RoleBean implements Serializable {

    private List<Role> roles;
    private Role role;
    public RoleBean() {
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public String toList() {
        RoleDAO dao = new RoleDAO();
        try {
            roles = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Roles";
    }

    public String delete() {
        RoleDAO dao = new RoleDAO();
        try {
            dao.delete(role);
            roles = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start() {
        role = new Role();
        return "Start";
    }
    
    public String save() {
        RoleDAO dao = new RoleDAO();
        try {
            if (role.getIdRole() != 0) {
                dao.update(role);
            } else {
                dao.insert(role);
            }
            roles = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel() {
        return "Cancel";
    }

    public String edit(Role role) {
        this.role = role;
        return "Edit";
    }

}
