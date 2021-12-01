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

@SpringBootApplication
public class StreamSplitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSplitterApplication.class, args);
    }


    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor(); // Or use another one of your liking
    }

    @Bean
    public CommandLineRunner commandLineRunner(TaskExecutor taskExecutor, Source source) {
        return args -> {
            System.out.println("Starting source");
            taskExecutor.execute(source);
        };

    }

}