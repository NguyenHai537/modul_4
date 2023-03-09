package com.codegym.bai_thi_modul4.service;

import com.codegym.bai_thi_modul4.model.Branch;
import com.codegym.bai_thi_modul4.model.Employee;

public interface IEmpoyeeService extends IGeneralService<Employee>{
    Iterable<Employee> findAllByBranch(Branch branch);
}
