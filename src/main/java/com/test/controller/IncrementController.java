package com.test.controller;

import com.test.Utils;
import com.test.model.Increment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IncrementController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/increment")
    public Increment increment(@RequestParam(value = "name", defaultValue = "World") String name) throws InterruptedException {
        long rnd= Utils.random(1000,2000);
        Thread.sleep(rnd);
        return new Increment(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/decrement")
    public Increment decrement(@RequestParam(value = "name", defaultValue = "World") String name) throws InterruptedException {
        long rnd= Utils.random(1000,2000);
        Thread.sleep(rnd);
        return new Increment(counter.decrementAndGet(), String.format(template, name));
    }
}
