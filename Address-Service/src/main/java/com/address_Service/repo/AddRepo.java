package com.address_Service.repo;

import com.address_Service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRepo extends JpaRepository<Address ,Integer> {

    @Query(value = "SELECT ae.id, ae.lane1, ae.lane2, ae.state, ae.zip " +
            "FROM address ae " +
            "JOIN employee e ON e.id = ae.employee_id " +
            "WHERE ae.employee_id = :employee_id", nativeQuery = true)
     Address findAddressByEmployeeId(@Param("employee_id") int employeeId);
}
