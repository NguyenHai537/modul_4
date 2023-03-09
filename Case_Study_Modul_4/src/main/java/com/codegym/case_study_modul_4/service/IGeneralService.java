package com.codegym.case_study_modul_4.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

   void saveAll(Iterable<T> entities);

}
