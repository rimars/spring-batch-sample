SpringBoot 안쓰는 경우 - CommandLineJobRunner
공식 docs 참고

- https://docs.spring.io/spring-batch/docs/4.3.6/reference/html/job.html#runningAJob
- https://kwonnam.pe.kr/wiki/springframework/batch/commandlinejobrunner


org.springframework.batch.core.launch.support.CommandLineJobRunner simple-job-launcher-context.xml ioSampleJob inputFile=D:/source/batch/gs-batch-processing/complete/src/main/resources/sample-data.csv
CommandLineJobRunner [xml파일명] [job이름] [paramKey1=value] [paramKey2=value] [paramKey3=value] ...

Boot에서는 아래 요소들을 이용해서 구성
1. BatchAutoConfiguration
2. JobLauncherCommandLineRunner
3. JobLauncherApplicationRunner

SpringBoot 3 부터는 @EnableBatchProcessing를 붙이면 auto-config기능이 비활성화

같은 파라미터로 재수행 불가하기에 파라미터 변경을 위해 JobParameter을 사용한다면 
allowStartIfComplete설정이나 Increment를 넣어주면 된다.


1. RunIdIncrementer
동일 파라미터인데 다시 실행하고 싶을때 

```
public Job job() {
    return jobBuilderFactory.get(JOB_NAME)
            .start(step(null))
            .incrementer(new RunIdIncrementer())
            .build();
}
```
Spring Boot 2에서 버그 발생




SpringBoot 3 부터는 spring.batch.job.enabled=true 일 때, jobName 누락하더라도 전체 job이 실행되지 않는다.
SpringBoot 2 까지는 spring.batch.job.enabled=false로 만들어야 jobName을 누락하는 경우 전체 job 실행되지 않았던 것 같은데,
SpringBoot 3 부터는 spring.batch.job.enabled=true여도 jobName 누락하더라도 전체 job이 실행되지 않는다. 옵션을 true로 놓아도 무방하다.