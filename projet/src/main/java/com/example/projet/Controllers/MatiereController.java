package com.example.projet.Controllers;

import com.example.projet.DTO.*;
import com.example.projet.Repositories.MatiereRepository;
import com.example.projet.Services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/matiere")
public class MatiereController {

    @Autowired
   private MatiereService matiereService;
    @PostMapping("/save")
    public String saveMatiere(@RequestBody MatiereSaveDTO matiereSaveDTO)
    {
        String id = matiereService.addMatiere(matiereSaveDTO);
        return id;
    }

    @DeleteMapping(path="/delete/{id}")
    public void supprimerMatiere(@PathVariable(value = "id")int id){
        Boolean matiere=matiereService.deleteMatiere(id);
    }

    @PutMapping("/update")
    public String updateMatiere(@RequestBody MatiereUpdateDTO matiereUpdateDTO){
        String id =matiereService.updateMatiere(matiereUpdateDTO);
        return id;
    }

    @GetMapping(path="getAllMatiere")
    public List<MatiereDTO> getAllMatiere(){
        List<MatiereDTO> allMatiere=matiereService.getAll();
        return allMatiere;
    }

    @GetMapping(path = "/getMatiere/{id}")
    public ResponseEntity<MatiereDTO> getMatiere(@PathVariable(value = "id") int id) {
        MatiereDTO matiereDTO = matiereService.getMatiere(id);

        if (matiereDTO != null) {
            return new ResponseEntity<>(matiereDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
