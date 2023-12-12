package com.example.projet.Repositories;

import com.example.projet.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
}
