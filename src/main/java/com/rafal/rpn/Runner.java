package com.rafal.rpn;

import com.rafal.rpn.core.RPNManager;
import com.rafal.rpn.model.RPNResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.rafal.rpn.utils.InputValidator.isParameterValid;
import static java.lang.String.format;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private RPNManager rpnManager;

    @Override
    public void run(String[] args) {
        if (isParameterValid(args)) {
            RPNResult rpnResult = rpnManager.calculate(args[0]);
            System.out.println(format("Status: %s", rpnResult.getStatus()));
            System.out.println(format("Result: %s", rpnResult.getResult()));
        }
    }
}
