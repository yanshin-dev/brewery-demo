package dev.yanshin.brewery.web.controller;

import dev.yanshin.brewery.services.CustomerService;
import dev.yanshin.brewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RequestMapping("api/v1/customers")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        var savedDto = customerService.createCustomer(customerDto);
        //todo: replace hardcode URI
        var newResourceURI = URI.create("api/v1/customers/" + savedDto.getId());
        return ResponseEntity.created(newResourceURI).body(savedDto);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId,
                               @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }

}
