package kg.itacademy.gsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class GsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsgApplication.class, args);
	}

}
