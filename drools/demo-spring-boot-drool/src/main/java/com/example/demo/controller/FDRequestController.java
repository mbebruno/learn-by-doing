package com.example.demo.controller;

import com.example.demo.models.FDRequest;
import com.example.demo.service.FDRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FDRequestController {

	private final FDRequestService fdRequestService;

	@Autowired
	public FDRequestController(FDRequestService fdRequestService) {
		this.fdRequestService = fdRequestService;
	}

    @RequestMapping(value = "/getFDInterestRate", method = RequestMethod.GET, produces = "application/json")
    public FDRequest getQuestions(@RequestParam(required = true) String bank, @RequestParam(required = true) Integer durationInYear) {
        FDRequest fdRequest=fdRequestService.getFDInterestRate(bank,durationInYear);
        return fdRequest;
    }
}