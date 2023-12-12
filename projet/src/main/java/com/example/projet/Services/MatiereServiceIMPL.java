package com.example.projet.Services;

import com.example.projet.DTO.*;
import com.example.projet.Entities.Enseignant;
import com.example.projet.Entities.Matiere;
import com.example.projet.Repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class MatiereServiceIMPL implements MatiereService{
    @Autowired
    private MatiereRepository matiereRepository;
    @Override
    public String addMatiere(MatiereSaveDTO matiereSaveDTO) {
        Matiere matiere=new Matiere(
                matiereSaveDTO.getId(),
                matiereSaveDTO.getNom()
        );
        matiereRepository.save(matiere);
        return matiereSaveDTO.getNom();
    }

    @Override
    public Boolean deleteMatiere(int id) {
        if(matiereRepository.existsById(id)){
            matiereRepository.deleteById(id);
        }
        else {
            System.out.println("matiere not found");
        }
        return true;
    }

    @Override
    public String updateMatiere(MatiereUpdateDTO matiereUpdateDTO) {
        if(matiereRepository.existsById(matiereUpdateDTO.getId())){
            Matiere matiere=matiereRepository.getById((matiereUpdateDTO.getId()));
            matiere.setNom(matiereUpdateDTO.getNom());

            matiereRepository.save(matiere);

        }
        else {
            System.out.println("employee id not found");
        }
        return null;
    }


    @Override
    public List<MatiereDTO> getAll() {
        List<Matiere> getmatieres=matiereRepository.findAll();
        List<MatiereDTO> matiereDTOList=new ArrayList<>();

        for (Matiere m :getmatieres)
        {
            MatiereDTO matiereDTO=new MatiereDTO(
                    m.getId(),
                    m.getNom()

                    );
            matiereDTOList.add(matiereDTO);
        }
        return matiereDTOList;
    }

    @Override
    public MatiereDTO getMatiere(int id) {
          if (matiereRepository.existsById(id)) {
            Matiere matiere = matiereRepository.findById(id).orElse(null);

            if (matiere != null) {
                return new MatiereDTO(
                        matiere.getId(),
                        matiere.getNom()
                        );
            } else {
                System.out.println("Matiere not found for ID: " + id);
            }
          } else {
              System.out.println("Matiere ID not found: " + id);
          }

        return null;
    }

    }

