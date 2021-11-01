/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.domingo.interfaces.InterfaceScore;
import tutoria.domingo.modelo.Score;

/**
 *
 * @author USER
 */
@Repository
public class RepositorioScore {
    @Autowired
    private InterfaceScore crud2;
    
     public List<Score> getAll(){
        return (List<Score>) crud2.findAll();       
    }
    
    public Optional <Score> getScore(int id){
        return crud2.findById(id);
    }
    
    public Score save(Score score){
        return crud2.save(score);
    }
     public void delete(Score score){
        crud2.delete(score);
    }
}
