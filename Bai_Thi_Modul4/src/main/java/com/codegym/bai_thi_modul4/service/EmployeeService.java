package com.codegym.bai_thi_modul4.service;

import com.codegym.bai_thi_modul4.model.Branch;
import com.codegym.bai_thi_modul4.model.Employee;
import com.codegym.bai_thi_modul4.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmpoyeeService{

    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);

    }

    @Override
    public void remove(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    public Iterable<Employee> findAllByBranch(Branch branch) {
        return iEmployeeRepository.findAllByBranch(branch);
    }
}
