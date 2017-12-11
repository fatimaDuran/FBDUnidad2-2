package utng.data;

import org.hibernate.HibernateException;

import utng.model.Role;

public class RoleDAO extends DAO<Role> {
    
     public RoleDAO() {
        super(new Role());
    }
    
    public Role getOneById(Role role) 
            throws HibernateException {
        return super.getOneById(role.getIdRole());
    }
}
