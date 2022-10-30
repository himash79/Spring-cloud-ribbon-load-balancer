package lk.himash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lk.himash.config.RibbonConfiguration;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RibbonClient(name = "serviceOne", configuration = RibbonConfiguration.class)
@RestController
@RequestMapping("v1/userApi")
public class ServiceClientApplication {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@GetMapping("/getDetails")
	public String invokeCharbook() {
		return template.getForObject("http://serviceOne/v1/userApi/getUsersDetails" , String.class);
//		return restTemplateBuilder.build().getForObject("http://serviceOne/v1/userApi/getUsersDetails", String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
