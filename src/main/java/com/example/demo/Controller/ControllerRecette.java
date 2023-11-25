package com.example.demo.Controller;

import com.example.demo.Model.Recette;
import com.example.demo.Service.RecetteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ControllerRecette {
    @Autowired
    private RecetteService recetteService;
    @PostMapping("/AddRecette")
    public ResponseEntity<Recette> AddRecette(@Valid @RequestBody Recette recette,@RequestParam Long id_user){
        ResponseEntity<Recette> recetteResponseEntity = new ResponseEntity<Recette>(recetteService.AjouterReccette(id_user, recette), HttpStatus.OK);
        return recetteResponseEntity;
    }
    @PutMapping("/modifierRecette")
    //Long id_rec,Recette newrecette
    public ResponseEntity<Recette> ModifierRecette(@Valid @RequestBody Recette recette, @RequestParam Long id_rec){
        ResponseEntity<Recette> recetteResponseEntity=new ResponseEntity<Recette>(recetteService.ModifierRecette(id_rec,recette),HttpStatus.OK);
        return recetteResponseEntity;
    }

    @DeleteMapping("/SupprimerRecette")
    public ResponseEntity<Recette> modifierRecette(@RequestParam Long id_rec){
        recetteService.SupprimerReccette(id_rec);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/LireRecette")
    public ResponseEntity<Recette> LireRecette(@RequestParam Long id_rec){
        recetteService.LireRecette(id_rec);
       return new ResponseEntity<>(recetteService.LireRecette(id_rec),HttpStatus.OK);
    }
}
