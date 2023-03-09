package com.codegym.bai_thi_modul4.service;

import com.codegym.bai_thi_modul4.model.Branch;
import com.codegym.bai_thi_modul4.repository.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService implements IBranchService{

    @Autowired
    private IBranchRepository iBranchRepository;

    @Override
    public Iterable<Branch> findAll() {
        return iBranchRepository.findAll();
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return iBranchRepository.findById(id);
    }

    @Override
    public void save(Branch branch) {
        iBranchRepository.save(branch);

    }

    @Override
    public void remove(Long id) {
        iBranchRepository.deleteById(id);

    }
}
