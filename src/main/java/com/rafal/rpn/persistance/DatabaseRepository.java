package com.rafal.rpn.persistance;

import com.rafal.rpn.model.RPNResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRepository implements RPNRepository<RPNResult, String> {

    @Value("${database.repo}")
    private String repo;

    @Override
    public String fetch() {
        throw new UnsupportedOperationException("Database store not supported yet");
    }

    @Override
    public void store(RPNResult result) {
        throw new UnsupportedOperationException("Database store not supported yet");
    }
}
