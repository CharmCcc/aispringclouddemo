package com.dgut.feign;

import com.dgut.entity.Order;
import com.dgut.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllById/{index}/{limit}/{uid}")
    public OrderVO findAllById(@PathVariable("index")int index,@PathVariable("limit")int limit,@PathVariable("uid")long uid);

    @GetMapping("/order/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index")int index,@PathVariable("limit")int limit);

    @GetMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id")long id);
}
