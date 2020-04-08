package com.example.springtaskdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableTask
@SpringBootApplication
public class SpringTaskDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTaskDemoApplication.class, args);
    }

    @Bean
    public TollProcessingTask tollPRocessingTask() {
        return new TollProcessingTask();
    }

    public static class TollProcessingTask implements CommandLineRunner {
        @Override
        public void run(String... args) {
            if (null != args) {
                log.info("params length: " + args.length);

                String stationId = args[0];
                String licensePlate = args[1];
                String timeStamp = args[2];

                log.info("Station Id is " + stationId +
                        ", license plate is " + licensePlate +
                        ", timestamp is " + timeStamp);
            }
        }
    }
}
