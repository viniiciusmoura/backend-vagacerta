package vagacerta.backend.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.Candidate;
import vagacerta.backend.model.service.CandidateService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/candidates")
public class CandidateController
{

    private final CandidateService service;

    @GetMapping
    public ResponseEntity<List<Candidate>> fetchAll()
    {
        return new ResponseEntity<List<Candidate>>(service.all(), HttpStatus.OK);
    } //Get All cadidatos

    @PostMapping("save")
    public ResponseEntity<Candidate> save(@Valid @RequestBody Candidate candidate)
    {
        return new ResponseEntity<Candidate>(service.create(candidate), HttpStatus.CREATED);
    } //Create Candidato

    @PatchMapping("update/{id}")
    public ResponseEntity<Candidate> update(@PathVariable Long id, @RequestBody Candidate candidate)
    {
        return new ResponseEntity<Candidate>(service.update(id, candidate), HttpStatus.OK);
    } //Update Candidato

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        if(service.delete(id)) {
            return new ResponseEntity<String>(HttpStatus.OK);
        }return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    } //Delete Candidato

    @GetMapping("office/{office}")
    public ResponseEntity<List<Candidate>> fetchOffice(@PathVariable String office)
    {
        return new ResponseEntity<List<Candidate>>(service.findByProfessionalExperienceOffice(office), HttpStatus.OK);
    } //Get All cadidatos by office

    @GetMapping("city/{city}")
    public ResponseEntity<List<Candidate>> fetchCity(@PathVariable String city)
    {
        return new ResponseEntity<List<Candidate>>(service.findAddressByCity(city), HttpStatus.OK);
    } //Get All cadidatos by city

    @GetMapping("state/{state}")
    public ResponseEntity<List<Candidate>> fetchState(@PathVariable String state)
    {
        return new ResponseEntity<List<Candidate>>(service.findAddressByState(state), HttpStatus.OK);
    } //Get All cadidatos by state

}
