package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.cat_vo;

public class cat_dao {
	public void insert(cat_vo cv) {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.save(cv);
		tr.commit();
	}

	public List search() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from cat_vo");
		List ls = q.list();
		return ls;
	}

	public List loadsrc(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from cat_vo where id='" + id + "'");
		List ls = q.list();
		return ls;

	}

	public void update(cat_vo cv) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.saveOrUpdate(cv);
		tr.commit();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		cat_vo cv = new cat_vo();
		cv.setId(id);
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		s.delete(cv);
		tr.commit();
	}

	public List AJAXSearch(cat_vo cv) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sf = new Configuration().configure()
		
				.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from cat_vo where E_type='"+cv.getEv().getId()+"'");
		List ls = q.list();
		return ls;
	}catch(Exception e){e.printStackTrace();}
		return null;
	}
	}


