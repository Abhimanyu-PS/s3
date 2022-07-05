package com.jocata.s3.daoutils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateUtils {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	public void closeSession(Session session) {
		if(session.isOpen()) session.close();
	}
	
	public <T> T save(T entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			Serializable id = session.save(entity);
			session.getTransaction().commit();
			return (T)id;
			
		}catch(Exception e) {e.printStackTrace();}
		finally { closeSession(session);}
		return null;
	}
	
	public <T> void update(T entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			
		}catch(Exception e) {e.printStackTrace();}
		finally { closeSession(session);}
		//return null;
	}
	public <T> void delete(T entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			//entity = session.get(entity.getClass(), entity)
			session.delete(entity);
			session.getTransaction().commit();
			
		}catch(Exception e) {e.printStackTrace();}
		finally { closeSession(session);}
		//return null;
	}
	public <T> T findEntityById(T entity, Serializable id) {
		Session session = getSession();
		try {
			return (T)session.get(entity.getClass(), id);
			
		}catch(Exception e) {e.printStackTrace();}
		finally { closeSession(session);}
		return null;
	}
	public <T> List<T> loadEntityByClassName(T entity) {
		Session session = getSession();
		try {
			Query<T> qry = session.createQuery("from " + entity.getClass().getName());
			return qry.list();
			
		}catch(Exception e) {e.printStackTrace();}
		finally { closeSession(session);}
		return null;
	}
	
	public <T> List<T> loadEntityByHql(String hql) {
		Session session = getSession();
		try {
			Query<T> qry = session.createQuery(hql);
			return qry.list();
			
		}catch(Exception e) {e.printStackTrace();}
		finally { closeSession(session);}
		return null;
	}

}
