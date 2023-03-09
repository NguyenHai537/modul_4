package com.codegym.case_study_modul_4.util.Mapper;
import com.codegym.case_study_modul_4.model.entity.Order;
import com.codegym.case_study_modul_4.model.entity.Product;
import com.codegym.case_study_modul_4.model.model.OrderModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ResponseMapper {
    @Autowired
    private  ModelMapper mapper;
    public OrderModel toOrderModel(Order order){
        return mapper.map(order, OrderModel.class);
    }

}
