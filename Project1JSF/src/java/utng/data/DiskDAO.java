/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Disk;



public class DiskDAO extends DAO<Disk> {
     public DiskDAO() {
        super(new Disk());
    }

    
    public Disk getOneById(Disk disk) throws HibernateException {
        return super.getOneById(disk.getIdDisk()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
