package vagacerta.backend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.Address;
import vagacerta.backend.model.response.AddressDTO;
import vagacerta.backend.model.response.CandidateDTO;
import vagacerta.backend.model.service.AddressService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/address")
public class AddressController
{

    private final AddressService service;

    //private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Address>> fetchAll()
    {
        return new ResponseEntity<List<Address>>(service.all(), HttpStatus.OK);
    } //Get All

    @GetMapping("states")
    public ResponseEntity<List<String>> fetchAllState()
    {
        return new ResponseEntity<List<String>>(service.getStateGroup(), HttpStatus.OK);
    } //Get All

    @GetMapping("company/{id}")
    public ResponseEntity<List<Address>> allCompanyId(@PathVariable Long id)
    {
        return this.findAllAddress(service.allCompanyId(id));
    }

    @GetMapping("candidate/{id}")
    public ResponseEntity<List<Address>> allCandidateId(@PathVariable Long id)
    {
        return this.findAllAddress(service.allCandidateId(id));
    }

    @PostMapping("save")
    public ResponseEntity<Address> save(@Valid @RequestBody Address address)
    {
        return new ResponseEntity<Address>(service.create(address), HttpStatus.CREATED);
    } //Create

    @PatchMapping("update/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address address)
    {
        return new ResponseEntity<Address>(service.update(id, address), HttpStatus.OK);
    } //Update

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        if(service.delete(id)) {
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    } //Delete

    
    private ResponseEntity<List<Address>> findAllAddress(List<Address> addresses)
    {
//        var addressDTOS = addresses
//                .stream()
//                .map(address -> modelMapper.map(address, AddressDTO.class))
//                .collect(Collectors.toList());
//        return new ResponseEntity<List<AddressDTO>>(addressDTOS, HttpStatus.OK);
        return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
    }
}
