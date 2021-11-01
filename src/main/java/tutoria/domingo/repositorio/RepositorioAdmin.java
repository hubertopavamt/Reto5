/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.domingo.interfaces.InterfaceAdmin;
import tutoria.domingo.modelo.Admin;

/**
 *
 * @author USER
 */
@Repository
public class RepositorioAdmin {
    @Autowired
    private InterfaceAdmin crud2;
    
     public List<Admin> getAll(){
        return (List<Admin>) crud2.findAll();       
    }
    
    public Optional <Admin> getAdmin(int id){
        return crud2.findById(id);
    }
    
    public Admin save(Admin admin){
        return crud2.save(admin);
    }
     public void delete(Admin admin){
        crud2.delete(admin);
    }
}
