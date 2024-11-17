package com.example.processing;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableBatchProcessing
@ImportResource("classpath:simple-job-launcher-context.xml")
public class BatchProcessingApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(BatchProcessingApplication.class, args);
//	}

    public static void main(String[] args) {
        try {
            // ApplicationContext를 생성하여 애플리케이션 실행
            ApplicationContext applicationContext = SpringApplication.run(BatchProcessingApplication.class, args);

            // 애플리케이션 종료 시 Exit Code 반환
            int exitCode = SpringApplication.exit(applicationContext);
            System.exit(exitCode);
        } catch (Exception e) {
            // 예외 발생 시 강제 종료
            System.exit(101); // java.lang.IllegalStateException: Failed to execute ApplicationRunner 케이스 처리
        }
    }
}
