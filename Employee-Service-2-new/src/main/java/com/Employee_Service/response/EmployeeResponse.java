package com.Employee_Service.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private String bloodGroup;
    private AddressResponse addressResponse;
}
