/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Admin;
import tutoria.domingo.repositorio.RepositorioAdmin;

/**
 *
 * @author USER
 */
@Service
public class ServiciosAdmin {
    @Autowired
    private RepositorioAdmin metodosCrud;
    
    public List<Admin> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Admin> getAdmin(int idAdmin){
        return metodosCrud.getAdmin(idAdmin);
    }
    
    public Admin save(Admin admin){
        if(admin.getId()==null){
            return metodosCrud.save(admin);
        }else{
            Optional<Admin> evt=metodosCrud.getAdmin(admin.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(admin);
            }else{
                return admin;
            }
        }
    }
    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin>g=metodosCrud.getAdmin(admin.getId());
            if(!g.isEmpty()){
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    g.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    g.get().setPassword(admin.getPassword());
                }
                return metodosCrud.save(g.get());
            }
        }
        return admin;
    }
    public boolean deleteAdmin(int adminId){
        Boolean d=getAdmin(adminId).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return d;
    }
}
