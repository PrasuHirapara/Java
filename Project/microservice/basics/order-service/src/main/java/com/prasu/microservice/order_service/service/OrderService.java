package com.prasu.microservice.order_service.service;

import com.prasu.microservice.order_service.client.InventoryClient;
import com.prasu.microservice.order_service.dto.OrderRequest;
import com.prasu.microservice.order_service.model.Order;
import com.prasu.microservice.order_service.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public Order placeOrder(OrderRequest orderRequest){
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (!inStock){
            throw new RuntimeException("Product with sku code " + orderRequest.skuCode() + " is not available for given quantity.");
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());

        orderRepository.save(order);
        return order;
    }
}
