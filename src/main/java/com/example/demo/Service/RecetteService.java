package com.example.demo.Service;

import com.example.demo.Model.Recette;
import com.example.demo.Model.User;
import com.example.demo.Repository.RecetteRepo;
import com.example.demo.Repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteService implements RecetteServiceInter {
    @Autowired
    private RecetteRepo recetteRepo;
    @Autowired
    private UserRepo userRepo;

    public Recette AjouterReccette(Long id_user, Recette recette){
        User user= userRepo.findById(id_user).orElseThrow(()->new EntityNotFoundException("User not found"));
        Recette recette1=new Recette();
        recette1.setRec_nom(recette.getRec_nom());
        recette1.setDuree(recette.getDuree());
        recette1.setImage(recette.getImage());
        recette1.setUser(user);
        recette1.setIngredient(recette.getIngredient());
        recette1.setPreparation(recette.getPreparation());
       return recetteRepo.save(recette1);
    }
    public void SupprimerReccette(Long id){
        Recette recette = recetteRepo.findById(id).orElseThrow(()->new EntityNotFoundException("recette not found"));
        recetteRepo.deleteById(recette.getId());
    }
    public Recette ModifierRecette(Long id_rec,Recette newrecette){
        Recette oldrecette = recetteRepo.findById(id_rec).orElseThrow(()->new EntityNotFoundException("recette not found"));
        oldrecette.setRec_nom(newrecette.getRec_nom());
        oldrecette.setDuree(newrecette.getDuree());
        oldrecette.setImage(newrecette.getImage());
        oldrecette.setPreparation(newrecette.getPreparation());
        oldrecette.setIngredient(newrecette.getIngredient());
        return recetteRepo.save(oldrecette);
    }
    public Recette LireRecette(Long id_rec){
        Recette recette = recetteRepo.findById(id_rec).orElseThrow(()->new EntityNotFoundException("recette not found"));
        return recette;
    }

}
