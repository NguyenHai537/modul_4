package com.codegym.case_study_modul_4.service.thirdService;

import com.codegym.case_study_modul_4.model.dto.OrderDetailRequestDto;
import com.codegym.case_study_modul_4.model.dto.OrderDto;
import com.codegym.case_study_modul_4.model.entity.*;
import com.codegym.case_study_modul_4.model.model.OrderModel;
import com.codegym.case_study_modul_4.model.model.TransportationModel;
import com.codegym.case_study_modul_4.repository.IInventoryOrderRepository;
import com.codegym.case_study_modul_4.repository.ITransportationRepository;
import com.codegym.case_study_modul_4.repository.OrderDetailRepository;
import com.codegym.case_study_modul_4.service.IInventoryOrderService;
import com.codegym.case_study_modul_4.service.IProductService;
import com.codegym.case_study_modul_4.service.ITruckService;
import com.codegym.case_study_modul_4.util.Mapper.RequestMapper;
import com.codegym.case_study_modul_4.util.Mapper.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@org.springframework.stereotype.Service
public class HandleService {
    @Autowired
    private IInventoryOrderRepository inventoryOrderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ResponseMapper responseMapper;
    @Autowired
    private ITruckService iTruckService;
    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private IInventoryOrderService inventoryOrderService;
    @Autowired
    private ITransportationRepository iTransportationRepository;



    public void save(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        inventoryOrderRepository.save(order);
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails = buildOrderDetail(order, orderDto);
        orderDetailRepository.saveAll(orderDetails);
    }
    private List<OrderDetail> buildOrderDetail(Order order, OrderDto orderDto) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        List<OrderDetailRequestDto> orderDetailRequestDtos = orderDto.getOrderDetailRequestDtos();
        for(OrderDetailRequestDto ele : orderDetailRequestDtos){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct_id(ele.getProductId());
            orderDetail.setQuantity(Long.valueOf(ele.getQuantity()));
            orderDetail.setOrder(order);
            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }


    public  ResponseEntity<?> sendOrder(Long id, Date date){
        RestTemplate restTemplate = new RestTemplate();
        Order order = new Order();
        if (inventoryOrderRepository.findById(id).isPresent()){
             order = inventoryOrderRepository.findById(id).get();
        }
        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailByOrderId(order.getId());
        Long totalPrice = 0L;
        Long totalWeight = 0L;
        Product product = new Product();
        for (OrderDetail od: orderDetails
             ) {
            if (iProductService.findById(Long.valueOf(od.getProduct_id())).isPresent()){
                product = iProductService.findById(Long.valueOf(od.getProduct_id())).get();
            }
            totalWeight = od.getQuantity() * product.getWeigth();
            totalPrice += od.getQuantity() * product.getPrice();
        }

        List<Transportation> transportationList = new ArrayList<>();
        Transportation transportation = new Transportation();
        for (Truck t: iTruckService.findAll()
        ) {
            if (t.getStatus().equals("none")) {
                if (totalWeight <= t.getWeight()) {
                    transportation = requestMapper.toTransportation(t);
                    transportation.setOrder(order);
                    transportationList.add(transportation);
                    t.setStatus("shipping");
                    break;
                }
                if (totalWeight > t.getWeight()) {
                    totalWeight = totalWeight - t.getWeight();
                    transportation = requestMapper.toTransportation(t);
                    transportation.setOrder(order);
                    transportationList.add(transportation);
                    t.setStatus("shipping");
                }
            }
        }

        iTransportationRepository.saveAll(transportationList);

        order.setTotalPrice(totalPrice);
        order.setDelivery(date);
        order.setStatus("Delivering");
        inventoryOrderRepository.save(order);
        OrderModel orderModel = responseMapper.toOrderModel(order);
        orderModel.setTransportationModels(requestMapper.toTransportationModelList(transportationList));
        //HttpEntity<OrderModel> entity = new HttpEntity<>(orderModel);
        RequestEntity<?> request = RequestEntity.post("http://192.168.4.151:8080/import/confirmation")
                .accept(MediaType.APPLICATION_JSON)
                .body(orderModel);
        ResponseEntity<?> response = restTemplate.exchange(request,String.class);
        return response;
    }


    public ResponseEntity<?> handleOrder (OrderDto orderDto) {
        Order order = inventoryOrderService.findById(orderDto.getId()).get();
        order.setStatus(orderDto.getStatus());
        order.setDebt(order.getTotalPrice());
        order.setTotalPrice(0L);
        inventoryOrderRepository.save(order);
        List<Transportation> transportationList = iTransportationRepository.findByOrderId(order.getId());
        List<Truck> trucks = new ArrayList<>();
        Truck truck;
        for (Transportation tr: transportationList
             ) {
            truck = iTruckService.findTruckByLicensePlates(tr.getLicensePlates());
            truck.setStatus("none");
            trucks.add(truck);
        }
        iTruckService.saveAll(trucks);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

