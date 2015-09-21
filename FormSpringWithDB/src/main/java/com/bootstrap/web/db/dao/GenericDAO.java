package com.bootstrap.web.db.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.IdentifiableType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

public abstract class GenericDAO<T extends Serializable> {

	@PersistenceContext/*(unitName = "demo")*/
	protected EntityManager em;
	protected Class<T> type;
	@Autowired private DataSource dataSource;
	/*
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public GenericDAO() {		
		ParameterizedType pt = (ParameterizedType) ( ClassUtils.isCglibProxyClass(this.getClass()) ? getClass().getSuperclass().getGenericSuperclass() : getClass().getGenericSuperclass() );
		Type intermediateType = pt.getActualTypeArguments()[0];
		if (intermediateType instanceof Class) {
			this.type = (Class<T>) intermediateType;
	    } 
		else if (intermediateType instanceof ParameterizedType) {
			this.type = (Class<T>) ((ParameterizedType) intermediateType).getRawType();
	    }
	}

	/** Return type class */
	public Class<T> getType() {
		return type;
	}

	/** Return type name */
	public String getTypeName(boolean fullName) {
		return fullName ? type.getName() : type.getSimpleName();
	}

	/** Get Primary Key Field */
	public SingularAttribute<? super T, ?> getPKAttribute() {
		Metamodel metaModel = this.em.getMetamodel();
		IdentifiableType<T> identityType = (IdentifiableType<T>) metaModel.managedType(type);
		return identityType.getId(identityType.getIdType().getJavaType());
	}
	
	/** Get Criteria Query **/
	public CriteriaQuery<T> getCriteriaQuery() {
		return this.em.getCriteriaBuilder().createQuery(type);		
	}
	
	public CriteriaUpdate<T> getCriteriaUpdate() {
		return this.em.getCriteriaBuilder().createCriteriaUpdate(type);		
	}

    public CriteriaDelete<T> getCriteriaDelete() {
        return this.em.getCriteriaBuilder().createCriteriaDelete(type);
    }
	
	/** Add Fetch List to Root Type **/
	public void addFetchList(Root<T> typeRoot, Collection<String> includes) {
		// add fetch list
		for (String relation : includes) {
			FetchParent<T, T> fetch = typeRoot;
			for (String pathSegment : relation.split("\\.")) {
				fetch = fetch.fetch(pathSegment, JoinType.LEFT);
			}
		}
	}

	/** Persist the newInstance object into database */
	@Transactional
	public T create(T newInstance) {
		this.em.persist(newInstance);
		return newInstance;
	}

    @Transactional
    public void create(Collection<T> newInstanceCollection) {
        for (T newInstance : newInstanceCollection) {
            this.em.persist(newInstance);
        }
    }

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * with optional include parameters 
	 */
	public <PK extends Serializable> T getByKey(PK Id) {
		return this.getByKey(Id, new ArrayList<String>(), false);
	}
	
	public <PK extends Serializable> T getByKey(PK Id, Collection<String> includes) {
		return this.getByKey(Id, includes, false);
	}

	@SuppressWarnings("unchecked")
	public <PK extends Serializable> T getByKey(PK Id, Collection<String> includes, boolean isDistinct) {
		CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = this.getCriteriaQuery();		
		Root<T> typeRoot = criteriaQuery.from(type);	
		this.addFetchList(typeRoot, includes);
		criteriaQuery.select(typeRoot).distinct(isDistinct).where(
				criteriaBuilder.equal(typeRoot.get(this.getPKAttribute()), Id));
		final Query query = this.em.createQuery(criteriaQuery);
		return (T) JPAHelpers.getSingleResultOrNull(query);
	}

	/** Save changes made to a persistent object. */	
	@Transactional
	public T update(T transientObject) {
		return this.em.merge(transientObject);
	}
	
	@Transactional
	public void update(Collection<T> persistentObjectCollection) {
		for(T object: persistentObjectCollection) {
			object = this.em.merge(object);
		}
	}

	/** Remove an object from persistent storage in the database */	
	@Transactional
	public void delete(final Collection<T> persistentObjectCollection) {
		for(T object: persistentObjectCollection) {
			this.em.remove(object);
		}
	}
	@Transactional
	public <PK extends Serializable> void deleteByKey(final Collection<PK> keyCollection) {
		for(PK key: keyCollection) {
			this.em.remove(this.em.getReference(type, key));
		}
	}
	@Transactional
	public void delete(final T persistentObject) {
		this.em.remove(persistentObject);
	}
	@Transactional
	public <PK extends Serializable> void deleteByKey(PK Id) {
		this.em.remove(this.em.getReference(type, Id));
	}

	/**
	 * get all occurrences or count of object in database with optional include list
	 * Because of left joins with many-to-many relationships, optional distinct flag is added
	 */
	public List<T> getAll() {
		return this.getAll(new ArrayList<String>(), false);
	}
	
	public List<T> getAll(Collection<String> includes) {
		return this.getAll(includes, false);
	}
		
	public List<T> getAll(Collection<String> includes, boolean isDistinct) {
		CriteriaQuery<T> criteriaQuery = this.getCriteriaQuery();
		Root<T> typeRoot = criteriaQuery.from(type);	
		this.addFetchList(typeRoot, includes);
		criteriaQuery.select(typeRoot).distinct(isDistinct);		
		final TypedQuery<T> query = this.em.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public Long countAll() {
		CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<T> typeRoot = criteriaQuery.from(type);		
		criteriaQuery.select(criteriaBuilder.count(typeRoot));
		final Query query = this.em.createQuery(criteriaQuery);
		return (Long) query.getSingleResult();
	}
	
	public Connection getConnectionByEntityManager() throws SQLException{
        return this.dataSource.getConnection();
	}
}
