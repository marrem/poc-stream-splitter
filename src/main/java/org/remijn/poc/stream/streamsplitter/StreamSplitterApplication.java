package org.remijn.poc.stream.streamsplitter;

import org.remijn.poc.stream.streamsplitter.ingress.Source;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

@SpringBootApplication
public class StreamSplitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSplitterApplication.class, args);
    }


    // TaskExecutor bean heeft spring al in de context gezet.

    @Bean
    public CommandLineRunner commandLineRunner(TaskExecutor taskExecutor, Source source) {
        return args -> {
            System.out.println("Starting source");
            taskExecutor.execute(source);
        };

    }

    @Bean
    public BlockingQueue<Integer> blockingQueue() {
        return new LinkedBlockingQueue<>(10);
    }


}