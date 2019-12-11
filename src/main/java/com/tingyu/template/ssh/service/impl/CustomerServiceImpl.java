package com.tingyu.template.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tingyu.template.ssh.dao.CustomerDao;
import com.tingyu.template.ssh.entities.Customer;
import com.tingyu.template.ssh.query.CustomerQuery;
import com.tingyu.template.ssh.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerQuery> implements CustomerService {

	@SuppressWarnings("unused")
	private CustomerDao CustomerDao;

	@Autowired
	public void setCustomerDao(CustomerDao CustomerDao) {
		this.CustomerDao = CustomerDao;
		this.baseDao = CustomerDao;
	}
}
