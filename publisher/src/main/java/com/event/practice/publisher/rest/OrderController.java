package com.event.practice.publisher.rest;

import com.event.practice.common.dto.OrderDto;
import com.event.practice.publisher.service.EventPublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final EventPublisherService eventPublisherService;

    @PostMapping
    @ResponseStatus(NO_CONTENT)
    public void receiveOrder(@RequestBody OrderDto orderDto) {
        eventPublisherService.publishOrderReceivedEvent(orderDto);
    }
}
