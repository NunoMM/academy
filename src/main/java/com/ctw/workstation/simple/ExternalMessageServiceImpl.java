package com.ctw.workstation.simple;

import io.quarkus.logging.Log;

public class ExternalMessageServiceImpl implements ExternalMessageService {

    @Override
    public String sayHelloFromOuterSpace() {
        Log.info("Hello from OuterSpace");
        return "Say Hello from Outer Space";
    }

    @Override
    public String sayHelloFromOuterSpace(String message) {
        return "Say Hello from Outer Space " + message;
    }

    @Override
    public void fazAlgo() {

    }
}
