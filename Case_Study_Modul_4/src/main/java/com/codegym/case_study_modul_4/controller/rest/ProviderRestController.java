package com.codegym.case_study_modul_4.controller.rest;


import com.codegym.case_study_modul_4.model.dto.OrderDto;
import com.codegym.case_study_modul_4.model.entity.Order;
import com.codegym.case_study_modul_4.service.InventoryOrderService;
import com.codegym.case_study_modul_4.service.thirdService.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProviderRestController {

    @Autowired
    private InventoryOrderService inventoryOrderService;

    @Autowired
    private HandleService handleService;


    @PostMapping("/order")
    public ResponseEntity<?> saveInventoryOrder(@RequestBody OrderDto orderDto){
        handleService.save(orderDto);
        return new ResponseEntity<>(orderDto,HttpStatus.CREATED);
    }

    @PostMapping("/confirmation")
    public ResponseEntity<?> sendOrder(@RequestBody Order order){
        ResponseEntity<?> response = handleService.sendOrder(order.getId(),order.getDelivery());
        if (response.getStatusCode() == HttpStatus.OK){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/verified")
    public ResponseEntity<?> finalOrder(@RequestBody OrderDto orderDto){
        ResponseEntity<?> response =handleService.handleOrder(orderDto);
        if (response != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


//    @GetMapping("/lists")
//    public ResponseEntity<?> getLists(){
//        return new ResponseEntity<>(
//                inventoryOrderService.findAll(),HttpStatus.OK);
//    }

}
