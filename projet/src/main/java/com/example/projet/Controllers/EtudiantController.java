package com.example.projet.Controllers;

import com.example.projet.DTO.EnseignantDTO;
import com.example.projet.DTO.EtudiantDTO;
import com.example.projet.DTO.EtudiantSaveDTO;
import com.example.projet.DTO.EtudiantUpdateDTO;
import com.example.projet.Entities.Etudiant;
import com.example.projet.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/etudiant")
public class EtudiantController {

@Autowired
private EtudiantService etudiantService;

@PostMapping(path="/save")
    public String saveEtudiant(@RequestBody EtudiantSaveDTO etudiantSaveDTO){

        String id= etudiantService.addEtudiant(etudiantSaveDTO);
        return id;
    }

    @GetMapping(path="getAllEtudiants")
    public List<EtudiantDTO> getAllEtudiants()
    {
        List<EtudiantDTO> allEtudiants= etudiantService.getAllEtudiants();
        return allEtudiants;
    }


    @PutMapping(path="/update")
    public String updateEtudiant(@RequestBody EtudiantUpdateDTO etudiantUpdateDTO){

        String  id= etudiantService.updateEtudiant(etudiantUpdateDTO);
        return id;
    }


    @DeleteMapping(path="/delete/{id}")
    public String deleteEtudiant(@PathVariable(value="id")Long id){

        boolean  deleteEtudiant= etudiantService.deleteEtudiant(id);
        return "deleted";
    }

    @GetMapping(path = "/getEtudiant/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiant(@PathVariable(value = "id") Long id) {
        EtudiantDTO etudiantDTO = etudiantService.getEtudiant(id);

        if (etudiantDTO != null) {
            return new ResponseEntity<>(etudiantDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
