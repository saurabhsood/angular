package main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableTask
@EnableBatchProcessing
@ComponentScan("config")
public class App implements CommandLineRunner {
//    public static void main(String[] args) {
//        // Spring Java config
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(SpringConfig.class);
//        context.register(SpringBatchConfig.class);
//        context.refresh();
//         
//        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//        Job job = (Job) context.getBean("userJob");
//        System.out.println("Starting the batch job");
//        try {
//            JobExecution execution = jobLauncher.run(job, new JobParameters());
//            System.out.println("Job Status : " + execution.getStatus());
//            System.out.println("Job completed");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Job failed");
//        }
//    }
    
	@Autowired
    JobLauncher jobLauncher;
     
    @Autowired
    Job job;
     
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception
    {
        JobParameters params = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
        jobLauncher.run(job, params);
    }


    
}
