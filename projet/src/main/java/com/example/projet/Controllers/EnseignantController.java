package com.example.projet.Controllers;

import com.example.projet.DTO.EnseignantDTO;
import com.example.projet.DTO.EnseignantSaveDTO;
import com.example.projet.DTO.EnseignantUpdateDTO;
import com.example.projet.Entities.Enseignant;
import com.example.projet.Services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
   @RequestMapping("api/v1/enseignant")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @PostMapping(path = "/save")
    public String saveEnseignant(@RequestBody EnseignantSaveDTO enseignantSaveDTO)
       {
        String id = enseignantService.addEnseignant(enseignantSaveDTO);
        return id;
       }

    @GetMapping(path="getAllEnseignant")
    public List<EnseignantDTO> getAllEnseignant(){
        List<EnseignantDTO> allEnseignants=enseignantService.getAllEnseignant();
        return allEnseignants;
    }
    @PutMapping(path="/update")
    public String updateEnseignant(@RequestBody EnseignantUpdateDTO enseignantUpdateDTO){
        String id = enseignantService.updateEnseignant(enseignantUpdateDTO);
        return id;
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteEnseignant(@PathVariable(value = "id")int id){
        Boolean deleteEnseignant = enseignantService.deleteEnseignant(id);
    }
    @GetMapping(path = "/getEnseignant/{id}")
    public ResponseEntity<EnseignantDTO> getEnseignant(@PathVariable(value = "id") int id) {
        EnseignantDTO enseignantDTO = enseignantService.getEnseignant(id);

        if (enseignantDTO != null) {
            return new ResponseEntity<>(enseignantDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
