package com.example.demo.Repository;

import com.example.demo.Model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface RecetteRepo extends JpaRepository<Recette,Long> {

}
