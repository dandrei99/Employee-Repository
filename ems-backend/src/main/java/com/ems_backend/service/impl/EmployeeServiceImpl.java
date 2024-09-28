package com.ems_backend.service.impl;

import com.ems_backend.dto.EmployeeDto;
import com.ems_backend.entity.Employee;
import com.ems_backend.exception.ResourceNotFoundExcepton;
import com.ems_backend.mapper.EmployeeMapper;
import com.ems_backend.repository.EmployeeRepository;
import com.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundExcepton("Employee does not exist with given id: "+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
       return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
               .collect(Collectors.toList());
    }
}
