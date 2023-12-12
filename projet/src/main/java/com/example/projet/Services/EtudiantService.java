package com.example.projet.Services;

import com.example.projet.DTO.EtudiantDTO;
import com.example.projet.DTO.EtudiantSaveDTO;
import com.example.projet.DTO.EtudiantUpdateDTO;

import java.util.List;

public interface EtudiantService {
    String addEtudiant(EtudiantSaveDTO etudiantSaveDTO);

    List<EtudiantDTO> getAllEtudiants();

    String updateEtudiant(EtudiantUpdateDTO etudiantUpdateDTO);

    boolean deleteEtudiant(Long id);

    EtudiantDTO getEtudiant(Long id);
}
