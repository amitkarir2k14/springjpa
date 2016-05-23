package app.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("app")
public class JpaApp {

	public static void main(String[] args) {
		SpringApplication.run(JpaApp.class, args);

	}
}
