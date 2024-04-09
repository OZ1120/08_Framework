package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.customer.model.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("addCustomer")
	public String addCustomer(
		@RequestParam("customerName")String customerName,
		@RequestParam("customerTel")String customerTel,
		@RequestParam("customerAddress")String customerAddress) {
		
		int result = service.addCustomer(customerName,customerTel,customerAddress);
		
		String path = null;
		if(result>0) {
			path = "result";
		}
			return  path;
		
		
	}

}
