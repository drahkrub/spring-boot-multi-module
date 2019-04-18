package de.idon.sandbox.web;

import de.idon.sandbox.base.SomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "de.idon.sandbox")
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}
    
    @RestController
    static class SomeRestController {
        
        private final SomeService someService;

        public SomeRestController(SomeService someService) {
            this.someService = someService;
        }

        @GetMapping("/")
        public String home() {
            return someService.doesItWork();
        }
    }
}
