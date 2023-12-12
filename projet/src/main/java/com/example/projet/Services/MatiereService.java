package com.example.projet.Services;

import com.example.projet.DTO.MatiereDTO;
import com.example.projet.DTO.MatiereSaveDTO;
import com.example.projet.DTO.MatiereUpdateDTO;

import java.util.List;

public interface MatiereService {
    String addMatiere(MatiereSaveDTO matiereSaveDTO);
    Boolean deleteMatiere(int id);
    String updateMatiere(MatiereUpdateDTO matiereUpdateDTOeDTO);
    List<MatiereDTO> getAll();
    MatiereDTO getMatiere(int id);


}
