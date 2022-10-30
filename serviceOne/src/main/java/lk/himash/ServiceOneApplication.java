package lk.himash;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("v1/userApi")
public class ServiceOneApplication {

	@Value("${server.port}")
	private String port;

	@GetMapping("/getUsersDetails")
	public String getUsersDetails() {
		return "Server initiate on port : " + port;
	}

	@GetMapping("/")
	public String refresh() {
		return "";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

}
