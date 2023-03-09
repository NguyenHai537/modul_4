package com.codegym.bai_thi_modul4.repository;

import com.codegym.bai_thi_modul4.model.Branch;
import com.codegym.bai_thi_modul4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Iterable<Employee> findAllByBranch(Branch Branch);
}
