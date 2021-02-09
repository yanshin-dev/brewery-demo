package dev.yanshin.brewery.services;

import dev.yanshin.brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .uuid(customerId)
                .name("David Beckham")
                .build();
    }
}
