/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Score;
import tutoria.domingo.repositorio.RepositorioScore;

/**
 *
 * @author USER
 */
@Service
public class ServiciosScore {
    @Autowired
    private RepositorioScore metodosCrud;
    
    public List<Score> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Score> getScore(int idScore){
        return metodosCrud.getScore(idScore);
    }
    
    public Score save(Score score){
        if(score.getScore()==null){
            return metodosCrud.save(score);
        }else{
            Optional<Score> evt=metodosCrud.getScore(score.getScore());
            if(evt.isEmpty()){
                return metodosCrud.save(score);
            }else{
                return score;
            }
        }
    }
    public Score update(Score score){
        if(score.getScore()!=null){
            Optional<Score>g=metodosCrud.getScore(score.getScore());
            if(!g.isEmpty()){
                if(score.getMessageText()!=null){
                    g.get().setMessageText(score.getMessageText());
                }
                return metodosCrud.save(g.get());
            }
        }
        return score;
    }
    public boolean deleteScore(int scoreId){
        Boolean d=getScore(scoreId).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return d;
    }
}
