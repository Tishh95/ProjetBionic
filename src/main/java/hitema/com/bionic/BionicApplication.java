package hitema.com.bionic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class BionicApplication {
	@RequestMapping("/")
	String home() {
		return "login.html";
	}


	public static void main(String[] args) {
		SpringApplication.run(BionicApplication.class, args);
	}

}
