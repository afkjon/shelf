package ca.jonathonho.shelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The main class for the Shelf application.
 */
@SpringBootApplication
public class ShelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelfApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
				registry.addMapping("/**").allowedOrigins("https://sfx.jonathonho.ca");
				registry.addMapping("/**").allowedOrigins("https://onomatopoeia-ref.onrender.com/");
			}
		};
	}
}
