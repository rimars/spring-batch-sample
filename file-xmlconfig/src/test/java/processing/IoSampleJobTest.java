package processing;

import com.example.processing.BatchConfiguration;
import config.TestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(locations = { "/jdbcCursor.xml",
        "/simple-job-launcher-context.xml" })
@SpringBootTest
@ImportAutoConfiguration(classes = {TestConfiguration.class})
public class IoSampleJobTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;


    @Test
    void testLaunchJobWithXmlConfig() throws Exception {
        // when
        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob();

        // then
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

    @Test
    public void testLaunchJobWithJavaConfig(@Qualifier("ioSampleJob") Job job) throws Exception {
        // given
        jobLauncherTestUtils.setJob(job);

        final JobParameters jobParameters =
                jobLauncherTestUtils
                        .getUniqueJobParametersBuilder()
                        .addString("date", "2023-06-01")
                        .toJobParameters();

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        // then
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

}
