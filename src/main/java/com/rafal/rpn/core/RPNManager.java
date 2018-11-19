package com.rafal.rpn.core;

import com.rafal.rpn.model.RPNResult;
import com.rafal.rpn.persistance.DatabaseRepository;
import com.rafal.rpn.persistance.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.rafal.rpn.model.OperationResult.FAILED;
import static com.rafal.rpn.model.OperationResult.SUCCESS;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Component
public class RPNManager {

    @Autowired
    private RPNCalculator rpnCalculator;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private DatabaseRepository databaseRepository;

    public RPNResult calculate(String input) {
        try {
            Double result = calculateBasedOnInput(input);
            return new RPNResult(SUCCESS, result);
        } catch (Exception e) {
            System.out.println(format("Cannot calculate rpn expression: %s ", e));
            return new RPNResult(FAILED, -1D);
        }
    }

    private Double calculateBasedOnInput(String input) {
        return isNotBlank(input) ? rpnCalculator.calculate(input) : rpnCalculator.calculate(fileRepository.fetch());
    }
}
