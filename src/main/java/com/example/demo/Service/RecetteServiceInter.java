package com.example.demo.Service;

import com.example.demo.Model.Recette;

public interface RecetteServiceInter {
     Recette AjouterReccette(Long id_user, Recette recette);
     void SupprimerReccette(Long id);
     Recette ModifierRecette(Long id_rec,Recette newrecette);
     Recette LireRecette(Long id_rec);

}
