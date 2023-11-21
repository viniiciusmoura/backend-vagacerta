package vagacerta.backend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vagacerta.backend.model.entity.Address;
import vagacerta.backend.model.service.AddressService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/address")
public class AddressController
{

    private final AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> fetchAll()
    {
        return new ResponseEntity<List<Address>>(service.all(), HttpStatus.OK);
    } //Get All

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

}
