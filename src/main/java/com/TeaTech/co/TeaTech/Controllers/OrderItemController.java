package com.TeaTech.co.TeaTech.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeaTech.co.TeaTech.Model.OrderItem;
import com.TeaTech.co.TeaTech.NotFoundException.OrderItemNotFoundException;
import com.TeaTech.co.TeaTech.Repository.OrderItemRepository;

@RestController
@RequestMapping("api/v1/OrderItem")
public class OrderItemController {

    OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    } 

    @GetMapping("/all")
    public List<OrderItem> getOrderItem(){
        return repo.findAll();
    }

    @GetMapping("/orderitem/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderItemNotFoundException(id));
    }

    @PostMapping("/orderitem/new")
    public String assOrderItem(@RequestBody OrderItem newOrderItem){
        repo.save(newOrderItem);
        return "A new order item is added";
    }

    @DeleteMapping("/orderitem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        repo.deleteById(id);
        return "A order item is deleted";
    }

}
