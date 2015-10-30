package com.bootstrap.web.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootstrap.web.db.model.User;

/**
 * Defines the data access methods for Customer persistence
 *
 * @author shaines
 */

@Repository("userDao")
public class UserDao extends GenericDAO<User>
{
   public User getByName(String username){
	   
	   CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = this.getCriteriaQuery();
		Root<User> typeRoot = criteriaQuery.from(type);	
		
		// Create Predicates
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(!StringUtils.isEmpty(username)) {
			predicates.add(criteriaBuilder.equal(typeRoot.get("username"), username));
		}

		criteriaQuery.select(typeRoot).distinct(true)
					 .where(predicates.toArray(new Predicate[0]));
		final javax.persistence.TypedQuery<User> query = this.em.createQuery(criteriaQuery);
		return query.getSingleResult();
   }
}