package example.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBatchApplication {

	@Autowired
	ConsumerMsg consumerMsg;

	public static void main(String[] args) throws MQClientException, InterruptedException {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

	@Bean
   	public CommandLineRunner commandLineRunner() {
    	return args -> consumerMsg.receiveMessages();
   	}
}