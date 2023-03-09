package com.codegym.case_study_modul_4.service;

import com.codegym.case_study_modul_4.model.entity.Truck;

public interface ITruckService extends IGeneralService<Truck>{

    Truck findTruckByLicensePlates(String licensePlates);
}
