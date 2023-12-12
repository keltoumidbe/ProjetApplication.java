package com.example.projet.Repositories;

import com.example.projet.DTO.MatiereSaveDTO;
import com.example.projet.Entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MatiereRepository extends JpaRepository<Matiere,Integer> {
}
