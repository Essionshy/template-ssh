package com.tingyu.template.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.tingyu.template.ssh.dao.CustomerDao;
import com.tingyu.template.ssh.entities.Customer;
import com.tingyu.template.ssh.query.CustomerQuery;

/**
 * 
 * @author Essionshy
 *
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer, CustomerQuery> implements CustomerDao {

	@Override
	public String createHQL(CustomerQuery q) {
		// TODO Auto-generated method stub
		return null;
	}
}
