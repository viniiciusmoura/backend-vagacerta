package vagacerta.backend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.Company;
import vagacerta.backend.model.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@AllArgsConstructor
public class CompanyController
{
    private final CompanyService service;

    @GetMapping
    public ResponseEntity<List<Company>> fetchAll()
    {
//        List<CompanyDTO> companys = service.all()
//                .stream()
//                .map(company -> modelMapper.map(company, CompanyDTO.class))
//                .collect(Collectors.toList());
        return new ResponseEntity<List<Company>>(service.all(), HttpStatus.OK);
    } //Get All Company

    @PostMapping("save")
    public ResponseEntity<Company> save(@Valid @RequestBody Company company)
    {
        return new ResponseEntity<Company>(service.create(company), HttpStatus.CREATED);
    } //Create Company

    @PatchMapping("update/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company)
    {
        return new ResponseEntity<Company>(service.update(id, company), HttpStatus.OK);
    } //Update Company


    @GetMapping("office/{office}")
    public ResponseEntity<List<Company>> fetchOffice(@PathVariable String office)
    {
        return new ResponseEntity<List<Company>>(service.findByVacanciesOffice(office), HttpStatus.OK);
    } //Get All by office

    @GetMapping("city/{city}")
    public ResponseEntity<List<Company>> fetchCity(@PathVariable String city)
    {
        return new ResponseEntity<List<Company>>(service.findAddressByCity(city), HttpStatus.OK);
    } //Get All by city

    @GetMapping("state/{state}")
    public ResponseEntity<List<Company>> fetchState(@PathVariable String state)
    {
        return new ResponseEntity<List<Company>>(service.findAddressByState(state), HttpStatus.OK);
    } //Get All by state

    @GetMapping("search/{search}")
    public ResponseEntity<List<Company>> fetchSearch(@PathVariable String search)
    {
        return new ResponseEntity<List<Company>>(service.findBySocialReasonLikeOrAreaOfActivity(search), HttpStatus.OK);
    } //Get All by serach


}
