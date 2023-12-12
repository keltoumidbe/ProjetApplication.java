package com.example.projet.Services;

import com.example.projet.DTO.EnseignantDTO;
import com.example.projet.DTO.EnseignantSaveDTO;
import com.example.projet.DTO.EnseignantUpdateDTO;
import com.example.projet.Entities.Enseignant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EnseignantService {
    String addEnseignant(EnseignantSaveDTO enseignantSaveDTO);

    List<EnseignantDTO> getAllEnseignant();

    String updateEnseignant(EnseignantUpdateDTO enseignantUpdateDTO);

    Boolean deleteEnseignant(int id);
    EnseignantDTO getEnseignant(int id);

}
