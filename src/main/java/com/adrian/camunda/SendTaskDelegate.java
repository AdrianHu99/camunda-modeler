package com.adrian.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendTaskDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("message")
                .processInstanceBusinessKey("messageBusiness")
                .correlate();
    }
}
