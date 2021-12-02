package org.remijn.poc.stream.streamsplitter.controllers;


import org.remijn.poc.stream.streamsplitter.ingress.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    private final BlockingQueue<Integer> queue;

    public HelloController(BlockingQueue<Integer> queue) {
       this.queue = queue;
    }


    @GetMapping("/")
    public String index() throws InterruptedException {

        Integer i = queue.poll(1, TimeUnit.SECONDS);

        return "Greetings from Spring Boot!: " + i;
    }

}