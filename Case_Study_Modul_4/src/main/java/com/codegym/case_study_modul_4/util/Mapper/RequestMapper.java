package com.codegym.case_study_modul_4.util.Mapper;
import com.codegym.case_study_modul_4.model.dto.*;
import com.codegym.case_study_modul_4.model.entity.*;
import com.codegym.case_study_modul_4.model.model.TransportationModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestMapper {
    @Autowired
    private  ModelMapper mapper;

    public Order toOrder(OrderDto orderDto){
        return mapper.map(orderDto,Order.class);
    }

    public TransportationModel toTransportationModel(Truck truck){
        return mapper.map(truck,TransportationModel.class);
    }

    public Transportation toTransportation(Truck truck){
        return mapper.map(truck,Transportation.class);
    }

    public List<TransportationModel> toTransportationModelList (List<Transportation> transportationList) {
        return transportationList.stream()
                .map( transportation -> mapper.map( transportation, TransportationModel.class ))
                .collect( Collectors.toList());
    }



}
