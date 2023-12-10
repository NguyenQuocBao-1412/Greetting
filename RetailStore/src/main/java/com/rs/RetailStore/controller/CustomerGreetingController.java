package com.rs.RetailStore.controller;

import com.rs.RetailStore.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1") // version
public class CustomerGreetingController {

    private static final String greetingTemplate = "Hello, %s %s"; /* Template string */
    private final AtomicLong counter = new AtomicLong(); /* đánh số tự động */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "gender", defaultValue = "0") boolean gender,
                             @RequestParam(value = "customerName", defaultValue = "Customer") String customerName
    ) {
        return Greeting.builder()
                .id(counter.incrementAndGet())
                .content(String.format(greetingTemplate, gender ? "Mr." : "Ms.", customerName))
                .build();
    }
}
