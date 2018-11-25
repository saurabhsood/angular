package config;

import java.util.Collections;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import model.DupUser;
import model.User;
import repository.DupUserRepository;
import repository.UserRepository;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    
    @Autowired
    private JobBuilderFactory jobs;
 
    @Autowired
    private StepBuilderFactory steps;
 
    @Autowired
    public UserRepository urepo; 
    
    @Autowired
    private DupUserRepository duprepo;
 
    @Bean(name = "UserReader")
    public RepositoryItemReader<User> reader() {
        RepositoryItemReader<User> reader = new RepositoryItemReader<>();
        reader.setRepository(urepo);
        reader.setMethodName("findAll");
        reader.setSort(Collections.singletonMap("userID", Sort.Direction.ASC));
        reader.setPageSize(100000);
        return reader;
    }
    
 
    @Bean
    public ItemProcessor<User,DupUser> itemProcessor() {
        return new UserProcessor();
    }
 
    @Bean
    public RepositoryItemWriter<DupUser> itemWriter()
       {
        RepositoryItemWriter<DupUser> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(duprepo);
        itemWriter.setMethodName("save");
        return itemWriter;
    }
 
    
    @Bean(name="step1")
    protected Step step1(ItemReader<User> reader,
      ItemProcessor<User, DupUser> processor,
      ItemWriter<DupUser> writer) {
        return steps.get("step1").<User,DupUser> chunk(100000)
          .reader(reader).processor(processor).writer(writer).build();
    }
 
    @Bean(name = "userJob")
    
    public Job job(@Qualifier("step1") Step step1) {
        return jobs.get("userJob").start(step1).build();
    }
}
