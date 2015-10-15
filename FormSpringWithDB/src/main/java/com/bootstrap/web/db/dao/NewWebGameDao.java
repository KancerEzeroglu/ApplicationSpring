package com.bootstrap.web.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootstrap.web.db.model.NewWebGame;

@Repository("newWebGameDao")
public class NewWebGameDao extends GenericDAO<NewWebGame>{
	
	public List<NewWebGame> search(String name, Date date) {
	
		CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<NewWebGame> criteriaQuery = this.getCriteriaQuery();
		Root<NewWebGame> typeRoot = criteriaQuery.from(type);	
		Root typeRoot2 = criteriaQuery.from(type);
		// Create Predicates
		List<Predicate> predicates = new ArrayList<Predicate>();
		// add list type

		if(!StringUtils.isEmpty(name)) {
			predicates.add(criteriaBuilder.equal(typeRoot.get("name"), name));
		}

		if(date != null){
			/*predicates.add(criteriaBuilder.greaterThan(typeRoot.get("date"), date));*/
			predicates.add(criteriaBuilder.greaterThan(typeRoot2.get("date"), date));
		}
		criteriaQuery.select(typeRoot).distinct(true)
					 .where(predicates.toArray(new Predicate[0]));
		final javax.persistence.TypedQuery<NewWebGame> query = this.em.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
