package com.Employee_Service.service;

import com.Employee_Service.entity.Employee;
import com.Employee_Service.repository.EmployeeRepo;
import com.Employee_Service.response.AddressResponse;
import com.Employee_Service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WebClient webClient;

//    @Autowired
//    private RestTemplate restTemplate;

//    EmployeeService( @Value("${addressservice.base.url}")  String addressBaseURL ,RestTemplateBuilder builder){
//        this.restTemplate = builder
//                .rootUri(addressBaseURL)
//                .build();
//    }


    public EmployeeResponse getEmployeeById(int id){


       Employee employee =  employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee , EmployeeResponse.class);
        AddressResponse addressResponse = webClient.get().uri(String.valueOf(id)).retrieve().bodyToMono(AddressResponse.class).block();
        employeeResponse.setAddressResponse(addressResponse);
return employeeResponse;
    }

//    private AddressResponse callingAddressServiceRESTTemplate(int id){
//        return restTemplate.getForObject("/{employeeId}",AddressResponse.class , id);
//
//    }
}
