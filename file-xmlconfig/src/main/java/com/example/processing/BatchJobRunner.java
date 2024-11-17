package com.example.processing;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.core.Job;
import java.util.*;

@SpringBootApplication
//@ImportResource("classpath:simple-job-launcher-context.xml")
public class BatchJobRunner implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job ioSampleJob;

    public static void main(String[] args) {
        SpringApplication.run(BatchJobRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting the Batch Job..." + args);

        // 명령줄 인수를 JobParameters로 변환
        Map<String, String> parametersMap = parseArgsToMap(args);
        JobParameters jobParameters = createJobParameters(parametersMap);

        jobLauncher.run(ioSampleJob, jobParameters);
    }

    // args를 Map으로 변환
    private Map<String, String> parseArgsToMap(String... args) {
        Map<String, String> map = new HashMap<>();
        for (String arg : args) {
            if (arg.contains("=")) {
                String[] split = arg.split("=", 2);
                map.put(split[0], split[1]);
            }
        }
        return map;
    }

    // Map을 JobParameters로 변환
    private JobParameters createJobParameters(Map<String, String> map) {
        JobParametersBuilder builder = new JobParametersBuilder();
        map.forEach(builder::addString);
        return builder.toJobParameters();
    }
}
