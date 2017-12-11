package utng.driver;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.ModuleDAO;
import utng.model.Module;

@ManagedBean
@SessionScoped
public class ModuleBean implements Serializable {
    private List<Module>modules;
    private Module module;
    public ModuleBean(){}

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    public String toList(){
        ModuleDAO dao = new ModuleDAO();
        try {
            modules=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Modules";
    }
    
    public String delete(){
         ModuleDAO dao = new ModuleDAO();
        try {
            dao.delete(module);
            modules=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        module= new Module();
        return "Start";
    }
    
    public String save(){
        ModuleDAO dao = new ModuleDAO();
        try {
            if(module.getIdModule()!= 0){
                dao.update(module);
            }else {
                dao.insert(module);
            }
            modules=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Module module){
        this.module=module;
        return "Edit";
    }
        
}
