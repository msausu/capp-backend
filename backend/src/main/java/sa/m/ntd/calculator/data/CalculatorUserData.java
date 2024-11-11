package sa.m.ntd.calculator.data;

import sa.m.ntd.calculator.model.CalculatorUser;

import java.util.List;

public interface CalculatorUserData {

    public static final List<CalculatorUser> USER_LIST = List.of(
            new CalculatorUser("john@gmail.com", "john0000", "Y"),
            new CalculatorUser("mary@gmail.com", "mary0000", "Y")
    );

}
