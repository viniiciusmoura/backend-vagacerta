package vagacerta.backend.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.ProfessionalExperience;
import vagacerta.backend.model.service.ProfessionalExperienceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/experiences")
public class ProfessionalExperienceController
{
    private final ProfessionalExperienceService service;

    @GetMapping
    public ResponseEntity<List<ProfessionalExperience>> fetchAll()
    {
        return new ResponseEntity<List<ProfessionalExperience>>(service.all(), HttpStatus.OK);
    } //Get All\

    @GetMapping("candidate/{id}")
    public ResponseEntity<List<ProfessionalExperience>> fetchCandidateXP(@PathVariable Long id)
    {
        return new ResponseEntity<List<ProfessionalExperience>>(service.getCandidateXP(id), HttpStatus.OK);
    } //Get All\


    @PostMapping("save")
    public ResponseEntity<ProfessionalExperience> save(@Valid @RequestBody ProfessionalExperience experience)
    {
        return new ResponseEntity<ProfessionalExperience>(service.createOrUpdate(experience), HttpStatus.CREATED);
    } //Create

    @PatchMapping("update/{id}")
    public ResponseEntity<ProfessionalExperience> update(@PathVariable Long id, @RequestBody ProfessionalExperience experience)
    {
        return new ResponseEntity<ProfessionalExperience>(service.createOrUpdate(experience), HttpStatus.OK);
    } //Update

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        if(service.delete(id)) {
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    } //Delete
}
