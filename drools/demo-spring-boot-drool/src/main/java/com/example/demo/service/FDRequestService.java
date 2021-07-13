package com.example.demo.service;

import com.example.demo.models.FDRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FDRequestService {

	private final KieContainer kieContainer;

	@Autowired
	public FDRequestService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public FDRequest getFDInterestRate(String bankName, Integer durationInYear) {
        //get the stateful session
        FDRequest fdRequest = new FDRequest(bankName,durationInYear);
        KieSession kieSession = kieContainer.newKieSession("FDRequestKS");       
		kieSession.insert(fdRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return fdRequest;
	}
}