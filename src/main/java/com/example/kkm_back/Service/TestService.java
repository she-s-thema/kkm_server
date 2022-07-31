package com.example.kkm_back.Service;

import com.example.kkm_back.Mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public void testXML() {
        System.out.println("server started");
        String testTXT = testMapper.testXML();
        System.out.println("TIMESTAMP : " + testTXT);
    }
}
