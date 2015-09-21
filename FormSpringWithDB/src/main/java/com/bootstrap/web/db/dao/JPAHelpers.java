package com.bootstrap.web.db.dao;

import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class JPAHelpers {
	public static Object getSingleResultOrNull(Query query) {
	    List<?> resultList = query.getResultList();
	    if (resultList.isEmpty()) return null;
        else if (resultList.size() == 1) return resultList.get(0);
        throw new NonUniqueResultException();
	}
}
