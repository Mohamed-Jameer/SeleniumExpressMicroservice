package com.Employee_Service.service;

import com.Employee_Service.entity.Employee;
import com.Employee_Service.feignclient.AddressClient;
import com.Employee_Service.repository.EmployeeRepo;
import com.Employee_Service.response.AddressResponse;
import com.Employee_Service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;


    public EmployeeResponse getEmployeeById(int id){


       Employee employee =  employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee , EmployeeResponse.class);
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        AddressResponse addressResponse1  =addressResponse.getBody();
        employeeResponse.setAddressResponse(addressResponse1);
return employeeResponse;
    }


}
