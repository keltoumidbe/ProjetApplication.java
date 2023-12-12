package com.example.projet.Services;

import com.example.projet.DTO.EnseignantDTO;
import com.example.projet.DTO.EtudiantDTO;
import com.example.projet.DTO.EtudiantSaveDTO;
import com.example.projet.DTO.EtudiantUpdateDTO;
import com.example.projet.Entities.Enseignant;
import com.example.projet.Entities.Etudiant;
import com.example.projet.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantServiceIMPL implements EtudiantService{

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public String addEtudiant(EtudiantSaveDTO etudiantSaveDTO) {

        Etudiant etudiant= new Etudiant(
                etudiantSaveDTO.getNom(),
                etudiantSaveDTO.getPrenom(),
                etudiantSaveDTO.getMatricule(),
                etudiantSaveDTO.getGenre()
        );
        etudiantRepository.save(etudiant);

        return etudiant.getNom();
    }

    @Override
    public List<EtudiantDTO> getAllEtudiants(){

        List<Etudiant> getEtudiants = etudiantRepository.findAll();
        List<EtudiantDTO> etudiantDTOList = new ArrayList<>();

        for(Etudiant e: getEtudiants){
            EtudiantDTO etudiantDTO= new EtudiantDTO(

                    e.getEtudiantid(),
                    e.getNom(),
                    e.getPrenom(),
                    e.getMatricule(),
                    e.getGenre()

            );
            etudiantDTOList.add(etudiantDTO);
        }

    return etudiantDTOList;
    }


    @Override
    public String updateEtudiant(EtudiantUpdateDTO etudiantUpdateDTO) {

        if(etudiantRepository.existsById(etudiantUpdateDTO.getEtudiantid()))
        {
            Etudiant etudiant = etudiantRepository.getById(etudiantUpdateDTO.getEtudiantid());

            etudiant.setNom(etudiantUpdateDTO.getNom());
            etudiant.setPrenom(etudiantUpdateDTO.getPrenom());
            etudiant.setMatricule(etudiantUpdateDTO.getMatricule());
            etudiant.setGenre(etudiantUpdateDTO.getGenre());

            etudiantRepository.save(etudiant);
        }
       else {
           System.out.println("Etudiant ID n'est pas trouvé");
        }
       return null;
    }


    @Override
    public boolean deleteEtudiant(Long id) {
        if(etudiantRepository.existsById(id)){
            etudiantRepository.deleteById(id);
        }
        else{
            System.out.println("Etudiant ID not found");
        }
        return true;
    }

    @Override
    public EtudiantDTO getEtudiant(Long id) {
        if (etudiantRepository.existsById(id)) {
            Etudiant etudiant = etudiantRepository.findById(id).orElse(null);

            if (etudiant != null) {
                return new EtudiantDTO(
                        etudiant.getEtudiantid(),
                        etudiant.getNom(),
                        etudiant.getPrenom(),
                        etudiant.getMatricule(),
                        etudiant.getGenre()

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
