package com.bootstrap.web.db.dao;

import org.springframework.stereotype.Repository;

import com.bootstrap.web.db.model.Customer;

/**
 * Defines the data access methods for Customer persistence
 *
 * @author shaines
 */

@Repository("customerDao")
public class CustomerDao extends GenericDAO<Customer>
{
   
}