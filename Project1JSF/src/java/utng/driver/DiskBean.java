package utng.driver;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.DiskDAO;
import utng.model.Disk;

@ManagedBean
@SessionScoped
public class DiskBean implements Serializable {
    private List<Disk>discs;
    private Disk disk;
    public DiskBean(){}

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public List<Disk> getDiscs() {
        return discs;
    }

    public void setDiscs(List<Disk> discs) {
        this.discs = discs;
    }
    
    public String tolist(){
        DiskDAO dao = new DiskDAO();
        try {
            discs=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Disk";
    }
    
    public String delete(){
         DiskDAO dao = new DiskDAO();
        try {
            dao.delete(disk);
            discs=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        disk= new Disk();
        return "Start";
    }
    
    public String save(){
        DiskDAO dao = new DiskDAO();
        try {
            if(disk.getIdDisk()!= 0){
                dao.update(disk);
            }else {
                dao.insert(disk);
            }
            discs=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Disk disk){
        this.disk=disk;
        return "Edit";
    }
        
}
