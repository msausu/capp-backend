package sa.m.ntd.calculator.setup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sa.m.ntd.calculator.repo.CalculatorUserRepository;
import sa.m.ntd.calculator.service.OperationService;

import java.util.Collections;

import static sa.m.ntd.calculator.data.CalculatorUserData.USER_LIST;

@Component
@Order(2)
class CalculatorUserSetup implements ApplicationRunner {

    private final CalculatorUserRepository calculatorUserRepository;

    public CalculatorUserSetup(CalculatorUserRepository calculatorUserRepository) {
        this.calculatorUserRepository = calculatorUserRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        calculatorUserRepository.saveAll(USER_LIST);
    }
}