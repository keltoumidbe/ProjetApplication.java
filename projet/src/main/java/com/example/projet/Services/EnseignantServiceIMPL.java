package com.example.projet.Services;
import com.example.projet.DTO.EnseignantDTO;
import com.example.projet.DTO.EnseignantSaveDTO;
import com.example.projet.DTO.EnseignantUpdateDTO;
import com.example.projet.Entities.Enseignant;
import com.example.projet.Repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnseignantServiceIMPL implements EnseignantService{
   @Autowired
    private EnseignantRepository enseignantRepository;
    @Override
    public String addEnseignant(EnseignantSaveDTO enseignantSaveDTO) {
        Enseignant enseignant=new Enseignant(
                enseignantSaveDTO.getNom(),
                enseignantSaveDTO.getPrenom(),
                enseignantSaveDTO.getEmail()
        );
        enseignantRepository.save(enseignant);
        return enseignant.getNom();
    }

    @Override
    public List<EnseignantDTO> getAllEnseignant() {
       List<Enseignant> getEnseignants=enseignantRepository.findAll();
       List<EnseignantDTO> enseignantDTOList=new ArrayList<>();

       for (Enseignant e :getEnseignants)
       {
           EnseignantDTO enseignantDTO=new EnseignantDTO(
                   e.getId(),
                   e.getNom(),
                   e.getPrenom(),
                   e.getEmail()
           );
           enseignantDTOList.add(enseignantDTO);
       }
       return enseignantDTOList;
    }

    @Override
    public String updateEnseignant(EnseignantUpdateDTO enseignantUpdateDTO) {
        if(enseignantRepository.existsById(enseignantUpdateDTO.getId())){
            Enseignant enseignant=enseignantRepository.getById((enseignantUpdateDTO.getId()));
            enseignant.setNom(enseignantUpdateDTO.getNom());
            enseignant.setPrenom(enseignantUpdateDTO.getPrenom());
            enseignant.setEmail(enseignantUpdateDTO.getEmail());
            enseignantRepository.save(enseignant);

        }
        else {
            System.out.println("employee id not found");
        }
        return null;
    }

    @Override
    public Boolean deleteEnseignant(int id) {
        if(enseignantRepository.existsById(id)){
            enseignantRepository.deleteById(id);
        }
        else {
            System.out.println("enseignant id not found");
        }
        return true;
    }

        @Override
        public EnseignantDTO getEnseignant(int id) {
            if (enseignantRepository.existsById(id)) {
                Enseignant enseignant = enseignantRepository.findById(id).orElse(null);

                if (enseignant != null) {
                    return new EnseignantDTO(
                            enseignant.getId(),
                            enseignant.getNom(),
                            enseignant.getPrenom(),
                            enseignant.getEmail()
                    );
                } else {
                    System.out.println("Enseignant not found for ID: " + id);
                }
            } else {
                System.out.println("Enseignant ID not found: " + id);
            }

            return null;
        }

}
