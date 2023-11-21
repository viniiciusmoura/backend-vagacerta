package vagacerta.backend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.Vacancies;
import vagacerta.backend.model.service.VacanciesService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/vacancies")
public class VacanciesController
{

    private final VacanciesService service;

    @GetMapping
    public ResponseEntity<List<Vacancies>> fetchAll()
    {
        return new ResponseEntity<List<Vacancies>>(service.all(), HttpStatus.OK);
    } //Get All

    @PostMapping("save")
    public ResponseEntity<Vacancies> save(@Valid @RequestBody Vacancies vacancies)
            
    {
        return new ResponseEntity<Vacancies>(service.createOrUpdate(vacancies), HttpStatus.CREATED);
    } //Create

    @PatchMapping("update/{id}")
    public ResponseEntity<Vacancies> update(@PathVariable Long id, @RequestBody Vacancies vacancies)
    {
        return new ResponseEntity<Vacancies>(service.createOrUpdate(vacancies), HttpStatus.OK);
    } //Update

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        if(service.delete(id)) {
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    } //Delete

    @GetMapping("office/{office}")
    public ResponseEntity<?> findOffice(@PathVariable String office)
    {
        return new ResponseEntity<>(service.findOffice(office), HttpStatus.OK);
    }

    @GetMapping("salary/greater/{salary}")
    public ResponseEntity<?> findOffice(@PathVariable BigDecimal salary)
    {
        return new ResponseEntity<>(service.findBySalaryGreaterThan(salary), HttpStatus.OK);
    }
}
