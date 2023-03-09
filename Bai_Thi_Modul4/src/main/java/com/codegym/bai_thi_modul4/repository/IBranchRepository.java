package com.codegym.bai_thi_modul4.repository;

import com.codegym.bai_thi_modul4.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch,Long> {
}
