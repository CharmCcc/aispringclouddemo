package com.dgut.controller;

import com.dgut.entity.Order;
import com.dgut.entity.OrderVO;
import com.dgut.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAllById/{index}/{limit}/{uid}")
    public OrderVO findAllById(@PathVariable("index")int index, @PathVariable("limit")int limit, @PathVariable("uid")long uid){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countById(uid));
        orderVO.setData(orderRepository.findAllById(index, limit,uid));
        return orderVO;
    }

    @GetMapping("/countById/{uid}")
    public int countById(@PathVariable("uid")long uid){
        return orderRepository.countById(uid);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index")int index,@PathVariable("limit")int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.count());
        orderVO.setData(orderRepository.findAll(index,limit));
        return orderVO;
    }

    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id")long id){
        orderRepository.updateState(id);
    }
}
