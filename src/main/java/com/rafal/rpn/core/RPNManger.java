package com.rafal.rpn.core;

import com.rafal.rpn.model.RPNResult;
import com.rafal.rpn.persistance.DatabaseRepository;
import com.rafal.rpn.persistance.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

import static com.rafal.rpn.model.OperationResult.FAILED;
import static com.rafal.rpn.model.OperationResult.SUCCESS;
import static com.rafal.rpn.utils.ExpressionParser.hasValidExpression;
import static java.lang.String.format;

@Component
public class RPNManger {

    @Autowired
    private RPNCalculator rpnCalculator;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private DatabaseRepository databaseRepository;

    public RPNResult calculate(String input) {
        try {
            Long result = calculateBasedOnInput(input);
            return new RPNResult(SUCCESS, result);
        } catch (Exception e) {
            System.out.println(format("Cannot calculate rpn expression: %s ", e));
            return new RPNResult(FAILED, -1L);
        }
    }

    private Long calculateBasedOnInput(String input) throws OperationNotSupportedException {
        return hasValidExpression(input) ? rpnCalculator.calculate(input) : rpnCalculator.calculate(fileRepository.fetch());
    }
}
