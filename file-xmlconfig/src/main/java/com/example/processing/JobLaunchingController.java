package com.example.processing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//@RestController
//public class JobLaunchingController {
//
//    private final JobLauncher jobLauncher;
//
//    private final ApplicationContext context;
//
//    public JobLaunchingController(JobLauncher jobLauncher, ApplicationContext context) {
//        this.jobLauncher = jobLauncher;
//        this.context = context;
//
//        System.out.println(jobLauncher);
//    }
//
//    @GetMapping("/run")
//    public String runJob() throws Exception { // @RequestBody JobLaunchRequest request
//        Job job = context.getBean("ioSampleJob", Job.class);
//
//        JobParameters param = new JobParametersBuilder().addLocalDateTime("test", LocalDateTime.now()).toJobParameters();
//
//        return jobLauncher.run(job, param).getExitStatus().toString();
//    }
//}
