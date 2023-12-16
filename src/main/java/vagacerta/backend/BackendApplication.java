package vagacerta.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vagacerta.backend.model.entity.User;
import vagacerta.backend.model.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
//	@Bean
//	CommandLineRunner runner(UserRepository userRepository) {
//		return args -> {
//			User user = new User("aaa@gmail.com", "1234567");
//			userRepository.save(user);
//		};
//	}
}
