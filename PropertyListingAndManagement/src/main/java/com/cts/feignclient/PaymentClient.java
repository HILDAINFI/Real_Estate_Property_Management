package com.cts.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.dto.OrderRequest;
import com.cts.dto.OrderResponse;

@FeignClient(name = "PAYMENT", url = "http://localhost:8083/pg")
public interface PaymentClient {

    @PostMapping("/createOrder")
    OrderResponse createOrder(@RequestBody OrderRequest orderRequest);
}
