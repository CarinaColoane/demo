package cl.example.demoBCI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class DemoBciApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBciApplication.class, args);
	}

}
