package com.example.projet.Repositories;

import com.example.projet.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    boolean existsById(Long etudiantid);

}
