package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Block;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String rec_nom;
    @NotBlank(message = "Duree is mandatory")
    private LocalDateTime duree;
    @ElementCollection
    private List<String> ingredient=new ArrayList<>();
    @ElementCollection
    private List<String> preparation=new ArrayList<>();
    @Column(nullable = true)
    @Lob
    private Blob image;
    @ManyToOne
    private User user;



}
