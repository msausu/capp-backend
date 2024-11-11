package sa.m.ntd.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CalculatorServiceApplication {

	public static final String
			CALCULATOR_API_BASE = "api", CALCULATOR_COLLETION_NAME = "RECORD_LOG";

	public static void main(String[] args) {
		SpringApplication.run(CalculatorServiceApplication.class, args);
	}

}
