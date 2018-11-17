package com.rafal.rpn.persistance;

import com.rafal.rpn.model.RPNResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements RPNRepository<RPNResult, String> {

    @Value("${file.repo}")
    private String repo;

    @Override
    public String fetch() {
        throw new UnsupportedOperationException("File store not supported yet");
    }

    @Override
    public void store(RPNResult result) {
        throw new UnsupportedOperationException("File store not supported yet");
    }

}
