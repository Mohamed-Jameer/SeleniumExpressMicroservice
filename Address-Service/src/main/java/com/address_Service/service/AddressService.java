package com.address_Service.service;

import com.address_Service.entity.Address;
import com.address_Service.repo.AddRepo;
import com.address_Service.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddRepo addRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(int employeeId){
        System.out.println(employeeId);
       Address address = addRepo.findAddressByEmployeeId(employeeId);
       return modelMapper.map(address , AddressResponse.class);
    }
}
